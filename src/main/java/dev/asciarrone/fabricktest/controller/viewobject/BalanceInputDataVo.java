package dev.asciarrone.fabricktest.controller.viewobject;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class BalanceInputDataVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2183335163788744653L;
	@NotBlank(message = "Account id cant'be empty")
	@Pattern(regexp = "[0-9]+", message = "AccountId must contain number")
	String accountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

}
