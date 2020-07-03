package dev.asciarrone.fabricktest.apiclient.service.object;

import java.io.Serializable;
import java.util.Date;

public class TransferInputSo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7573094806752761902L;

	String accountId;

	String receiverName;

	String description;

	String currency;

	String amount;

	Date executionDate;

	CreditorSo creditor;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public CreditorSo getCreditor() {
		return creditor;
	}

	public void setCreditor(CreditorSo creditor) {
		this.creditor = creditor;
	}

}
