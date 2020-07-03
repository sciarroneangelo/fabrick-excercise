package dev.asciarrone.fabricktest.apiclient.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.asciarrone.fabricktest.apiclient.apiobject.TransactionsApiObject;
import dev.asciarrone.fabricktest.apiclient.service.BaseService;
import dev.asciarrone.fabricktest.apiclient.service.TransactionService;
import dev.asciarrone.fabricktest.apiclient.service.object.TransactionSo;
import dev.asciarrone.fabricktest.db.dto.TransactionDto;
import dev.asciarrone.fabricktest.db.dto.TransactionTypeDto;
import dev.asciarrone.fabricktest.db.repository.TransactionRepository;
import dev.asciarrone.fabricktest.db.repository.TransactionTypeRepository;
import dev.asciarrone.fabricktest.mapper.TransactionMapper;

@Service
public class TransactionServiceImpl extends BaseService implements TransactionService {

	private final static String TRASFER_SERVICE_URL = BASE_SERVICE_URL
			+ "accounts/{accountId}/transactions?fromAccountingDate={fromDate}&toAccountingDate={toDate}";

	@Autowired
	TransactionMapper transactionMapper;

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	TransactionTypeRepository transactionTypeRepository;

	@Override
	public List<TransactionSo> loadTransactions(String accountId, String fromStringDate, String toStringDate) {
		if (accountId == null || fromStringDate == null || toStringDate == null) {
			throw new IllegalStateException();
		}
		HttpEntity<String> entity = new HttpEntity<String>("body", httpHeaders);
		String url = TRASFER_SERVICE_URL.replace("{accountId}", accountId).replace("{fromDate}", fromStringDate)
				.replace("{toDate}", toStringDate);

		ResponseEntity<TransactionsApiObject> res = restTemplate.exchange(url, HttpMethod.GET, entity,
				TransactionsApiObject.class);

		List<TransactionSo> soList = transactionMapper.apiListToSoList(res.getBody().getPayload().getList());

		saveTransactionsOnDb(soList);

		return soList;

	}

	private void saveTransactionsOnDb(List<TransactionSo> soList) {
		// if we can have performance problem we can use a bulk insert
		soList.forEach(so -> saveTransactionOndBb(so));

	}

	@Transactional
	private void saveTransactionOndBb(TransactionSo so) {
		TransactionDto dto = transactionMapper.soToDto(so);
		if (!transactionRepository.existsById(dto.getId())) {
			saveTransictionType(dto);
			transactionRepository.saveAndFlush(dto);
		}

	}

	@Transactional
	private void saveTransictionType(TransactionDto dto) {
		TransactionTypeDto foundedDto = transactionTypeRepository.findByValue(dto.getType().getValue());
		if (foundedDto == null) {
			transactionTypeRepository.saveAndFlush(dto.getType());
		} else {
			dto.setType(foundedDto);
		}
	}

}
