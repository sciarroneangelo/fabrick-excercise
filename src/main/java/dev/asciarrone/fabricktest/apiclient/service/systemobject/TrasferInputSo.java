package dev.asciarrone.fabricktest.apiclient.service.systemobject;

import java.io.Serializable;
import java.util.Date;

public class TrasferInputSo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7573094806752761902L;

	String accountId;

	String receiverName;

	String description;

	String currency;

	Double amount;

	Date excutionDate;

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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getExcutionDate() {
		return excutionDate;
	}

	public void setExcutionDate(Date excutionDate) {
		this.excutionDate = excutionDate;
	}

}
