package dev.asciarrone.fabricktest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class TransferControllerTest {

	private static String TRANSFER_URI = "http://localhost:8080/fabrick-test/v1.0/api/transfer/newMoneyTransfer";

	private static String VALID_BODY = "{\"accountId\":\"14537780\", \"receiverName\":\"John Doe\", \"description\":\"description\", \"currency\":\"EUR\", \"amount\":\"800\", \"executionDate\":\"03/07/2020\" }";

	private static String NOT_VALID_AMOUNT = "{\"accountId\":\"14537780\", \"receiverName\":\"John Doe\", \"description\":\"description\", \"currency\":\"EUR\", \"amount\":\"800.0.0\", \"executionDate\":\"03/07/2020\" }";

	private static String NON_VALID_DATE_FORMAT = "{\"accountId\":\"14537780\", \"receiverName\":\"John Doe\", \"description\":\"description\", \"currency\":\"EUR\", \"amount\":\"800\", \"executionDate\":\"2020/07/03\" }";

	private static String NON_VALID_DATE_VALUE = "{\"accountId\":\"14537780\", \"receiverName\":\"John Doe\", \"description\":\"description\", \"currency\":\"EUR\", \"amount\":\"800\", \"executionDate\":\"33/07/2020\" }";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testValidRequest() throws Exception {
		mockMvc.perform(post(TRANSFER_URI).contentType("application/json").content(VALID_BODY))
				.andExpect(status().is5xxServerError());

	}

	@Test
	public void testEmpyBody() throws Exception {
		mockMvc.perform(post(TRANSFER_URI).contentType("application/json")).andExpect(status().isBadRequest());

	}

	@Test
	public void testNotValidAmout() throws Exception {
		mockMvc.perform(post(TRANSFER_URI).contentType("application/json").content(NOT_VALID_AMOUNT))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void testNotValidDateFormat() throws Exception {
		mockMvc.perform(post(TRANSFER_URI).contentType("application/json").content(NON_VALID_DATE_FORMAT))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void testNotValidDateValue() throws Exception {
		mockMvc.perform(post(TRANSFER_URI).contentType("application/json").content(NON_VALID_DATE_VALUE))
				.andExpect(status().isBadRequest());

	}

}
