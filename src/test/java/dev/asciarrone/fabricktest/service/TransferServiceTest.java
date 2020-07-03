package dev.asciarrone.fabricktest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.asciarrone.fabricktest.apiclient.service.TransferService;
import dev.asciarrone.fabricktest.apiclient.service.object.TransferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TransferSo;

@SpringBootTest
public class TransferServiceTest {

	@Autowired
	TransferService transferService;

	@Test()
	public void testOK() {
		TransferInputSo so = new TransferInputSo();
		so.setAccountId("14537780");
		so.setReceiverName("John Doe");
		so.setDescription("description");
		so.setCurrency("EUR");
		so.setExecutionDate(new Date());
		so.setAmount("800");
		TransferSo output = transferService.newMoneyTransfer(so);
		assertNotNull(output);
		assertEquals(output.getErrors().get(0).getCode(), "API000");
		assertEquals(output.getStatus(), "KO");
	}

	@Test()
	public void testNullData() {
		assertThrows(IllegalStateException.class, () -> transferService.newMoneyTransfer(null));
	}

	@Test()
	public void testInvalidCreditor() {
		TransferInputSo so = new TransferInputSo();
		so.setAccountId("14537780");
		so.setReceiverName("John De");
		so.setDescription("description");
		so.setCurrency("EUR");
		so.setExecutionDate(new Date());
		so.setAmount("800");

		TransferSo output = transferService.newMoneyTransfer(so);
		assertNotNull(output);
		assertEquals(output.getErrors().get(0).getCode(), "CR0001");
		assertEquals(output.getStatus(), "KO");
	}

}
