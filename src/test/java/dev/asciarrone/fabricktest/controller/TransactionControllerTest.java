package dev.asciarrone.fabricktest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

	private static String TRANSACTION_URI = "http://localhost:8080/fabrick-test/v1.0/api/transaction/transactionList";

	private static String ACCOUNT_ID = "14537780";
	private static String FROM_DATE = "2019-01-01";
	private static String TO_DATE = "2019-12-01";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testMissingAccountId() throws Exception {
		String uri = TRANSACTION_URI + "?fromAccountingDate=" + FROM_DATE + "&toAccountingDate=" + TO_DATE;
		mockMvc.perform(get(uri).contentType("application/json")).andExpect(status().isBadRequest());
	}

	@Test
	public void testMissingFromDate() throws Exception {
		String uri = TRANSACTION_URI + "?accountId=" + ACCOUNT_ID + "&toAccountingDate=" + TO_DATE;
		mockMvc.perform(get(uri).contentType("application/json")).andExpect(status().isBadRequest());

	}

	@Test
	public void testMissingToDate() throws Exception {
		String uri = TRANSACTION_URI + "?fromAccountingDate=" + FROM_DATE + "&accountId=" + ACCOUNT_ID;
		mockMvc.perform(get(uri).contentType("application/json")).andExpect(status().isBadRequest());

	}

	@Test
	public void testValidUri() throws Exception {
		String uri = TRANSACTION_URI + "?accountId=" + ACCOUNT_ID + "&fromAccountingDate=" + FROM_DATE
				+ "&toAccountingDate=" + TO_DATE;
		mockMvc.perform(get(uri).contentType("application/json")).andExpect(status().isOk());

	}

}
