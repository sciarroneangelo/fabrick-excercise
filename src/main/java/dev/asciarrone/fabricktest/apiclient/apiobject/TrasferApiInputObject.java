package dev.asciarrone.fabricktest.apiclient.apiobject;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class TrasferApiInputObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6114822495421838704L;

	CreditorApiObject creditor;

	String executionDate;

	String description;

	String amount;

	String currency;

	// Tax relief not required in specification

	public CreditorApiObject getCreditor() {
		return creditor;
	}

	public void setCreditor(CreditorApiObject creditor) {
		this.creditor = creditor;
	}

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}
