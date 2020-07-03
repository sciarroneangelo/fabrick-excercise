package dev.asciarrone.fabricktest.apiclient.service;

import java.util.List;

import dev.asciarrone.fabricktest.apiclient.service.object.TransactionSo;

public interface TransactionService {

	List<TransactionSo> loadTransactions(String accountId, String fromStringDate, String toStringDate);

}
