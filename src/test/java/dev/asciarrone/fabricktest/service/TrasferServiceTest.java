package dev.asciarrone.fabricktest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.asciarrone.fabricktest.apiclient.service.TrasferService;
import dev.asciarrone.fabricktest.apiclient.service.object.TrasferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TrasferSo;

@SpringBootTest
public class TrasferServiceTest {

	@Autowired
	TrasferService trasferService;

	@Test()
	public void testOK() {
		TrasferInputSo so = new TrasferInputSo();
		so.setAccountId("14537780");
		so.setReceiverName("John Doe");
		so.setDescription("description");
		so.setCurrency("EUR");
		so.setExecutionDate(new Date());
		so.setAmount("800");
		TrasferSo output = trasferService.newMoneyTrasfer(so);
		assertNotNull(output);
		assertEquals(output.getErrors().get(0).getCode(), "API000");
		assertEquals(output.getStatus(), "KO");
	}

	@Test()
	public void testNullData() {
		assertThrows(IllegalStateException.class, () -> trasferService.newMoneyTrasfer(null));
	}

	@Test()
	public void testInvalidCreditor() {
		TrasferInputSo so = new TrasferInputSo();
		so.setAccountId("14537780");
		so.setReceiverName("John De");
		so.setDescription("description");
		so.setCurrency("EUR");
		so.setExecutionDate(new Date());
		so.setAmount("800");

		TrasferSo output = trasferService.newMoneyTrasfer(so);
		assertNotNull(output);
		assertEquals(output.getErrors().get(0).getCode(), "CR0001");
		assertEquals(output.getStatus(), "KO");
	}

}
