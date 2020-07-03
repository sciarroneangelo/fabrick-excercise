package dev.asciarrone.fabricktest.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpServerErrorException;

import dev.asciarrone.fabricktest.apiclient.service.BalanceService;

@SpringBootTest
public class BalanceServiceTest {

	@Autowired
	BalanceService balanceService;

	private String wrongAccountId = "notvalid";
	private String validAccountId = "14537780";

	@Test()
	public void testEmptyAccoountId() {
		assertThrows(IllegalStateException.class, () -> balanceService.readBalance(null));
	}

	@Test()
	public void testNotValidAccoountId() {
		assertThrows(HttpServerErrorException.class, () -> balanceService.readBalance(wrongAccountId));
	}

	@Test()
	public void testValidAccountId() {
		assertNotNull(balanceService.readBalance(validAccountId));
	}

}
