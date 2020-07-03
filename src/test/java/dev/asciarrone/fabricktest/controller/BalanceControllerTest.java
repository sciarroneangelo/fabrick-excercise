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
public class BalanceControllerTest {

	private static String BALANCE_URI = "http://localhost:8080/fabrick-test/v1.0/api/balance/getLastBalance";

	private static String VALID_BODY = "{\"accountId\":\"14537780\"}";

	private static String EMPTY_ACCOUNT_ID = "{\"accountId\":\"\"}";

	private static String NON_NUMERIC_ACCOUNT_ID = "{\"accountId\":\"14537780AAAA\"}";

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testValidRequest() throws Exception {

		mockMvc.perform(post(BALANCE_URI).contentType("application/json").content(VALID_BODY))
				.andExpect(status().isOk());

	}

	@Test
	public void testEmpyRequest() throws Exception {
		mockMvc.perform(post(BALANCE_URI).contentType("application/json").content(EMPTY_ACCOUNT_ID))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void testEmpyBody() throws Exception {
		mockMvc.perform(post(BALANCE_URI).contentType("application/json")).andExpect(status().isBadRequest());

	}

	@Test
	public void testNotNumeriRequest() throws Exception {
		mockMvc.perform(post(BALANCE_URI).contentType("application/json").content(NON_NUMERIC_ACCOUNT_ID))
				.andExpect(status().isBadRequest());

	}

}
