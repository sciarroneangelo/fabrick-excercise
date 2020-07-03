package dev.asciarrone.fabricktest.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.asciarrone.fabricktest.apiclient.service.impl.TransactionServiceImpl;
import dev.asciarrone.fabricktest.apiclient.service.object.TransactionSo;

@SpringBootTest
public class TransactionServiceTest {

	@Autowired
	TransactionServiceImpl transactionService;

	private static String ACCOUNT_ID = "14537780";
	private static String FROM_DATE = "2019-01-01";
	private static String TO_DATE = "2019-12-01";

	@Test()
	public void testOK() {
		List<TransactionSo> output = transactionService.loadTransactions(ACCOUNT_ID, FROM_DATE, TO_DATE);
		assertNotNull(output);
		assertTrue(output.size() > 0);
	}

	@Test()
	public void testNullFromDate() {
		assertThrows(IllegalStateException.class, () -> transactionService.loadTransactions(ACCOUNT_ID, null, TO_DATE));
	}

	@Test()
	public void testNullToDate() {
		assertThrows(IllegalStateException.class,
				() -> transactionService.loadTransactions(ACCOUNT_ID, FROM_DATE, null));
	}

	@Test()
	public void testNullAccountId() {
		assertThrows(IllegalStateException.class, () -> transactionService.loadTransactions(null, FROM_DATE, TO_DATE));
	}
}
