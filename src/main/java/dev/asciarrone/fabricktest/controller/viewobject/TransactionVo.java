package dev.asciarrone.fabricktest.controller.viewobject;

import java.io.Serializable;

public class TransactionVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6369916211432261386L;
	String transactionId;
	String operationId;
	String accountingDate;
	String valueDate;
	String amount;
	String currency;
	String description;

	TransactionTypeVo type;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public String getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TransactionTypeVo getType() {
		return type;
	}

	public void setType(TransactionTypeVo type) {
		this.type = type;
	}

}