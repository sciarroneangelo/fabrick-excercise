package dev.asciarrone.fabricktest.controller.viewobject;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TrasferInputDataVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7812442790217919517L;

	@NotBlank(message = "Account id cant'be empty")
	@Pattern(regexp = "[0-9]+", message = "AccountId must contain only number")
	String accountId;

	@NotBlank(message = "Receiver name cant'be empty")
	String receiverName;

	@NotBlank(message = "Description cant'be empty")
	String description;

	@NotBlank(message = "Currency cant'be empty")
	@Size(min = 3, max = 3)
	String currency;

	@NotBlank(message = "Receiver name cant'be empty")
	@Pattern(regexp = "^[+-]?([0-9]*[.])?[0-9]+$", message = "Amount must be a numerica value")
	String amount;

	@NotBlank(message = "Exceution date cant'be empty")
	@Pattern(regexp = " \"^\\\\d{2}-\\\\d{2}-\\\\d{4}$\"")
	String excutionDate;

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

	public String getExcutionDate() {
		return excutionDate;
	}

	public void setExcutionDate(String excutionDate) {
		this.excutionDate = excutionDate;
	}

}
