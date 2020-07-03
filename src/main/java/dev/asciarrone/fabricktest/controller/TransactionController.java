package dev.asciarrone.fabricktest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.asciarrone.fabricktest.apiclient.service.TransactionService;
import dev.asciarrone.fabricktest.controller.viewobject.TransactionVo;
import dev.asciarrone.fabricktest.mapper.TransactionMapper;

@RestController
@RequestMapping(BaseAbstractControllerV10.API_PREFIX + "/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;

	@Autowired
	TransactionMapper transactionMapper;

	@RequestMapping(value = "/transactionList")
	public @ResponseBody ResponseEntity<List<TransactionVo>> newMoneyTransfer(
			@RequestParam(name = "accountId") String accountId,
			@RequestParam(name = "fromAccountingDate") String fromStringDate,
			@RequestParam(name = "toAccountingDate") String toStringDate) {

		return ResponseEntity.status(HttpStatus.OK).body(transactionMapper
				.soListToVoList(transactionService.loadTransactions(accountId, fromStringDate, toStringDate)));
	}

}
