package dev.asciarrone.fabricktest.controller.viewobject;

import java.io.Serializable;

public class BalanceInputDataVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2183335163788744653L;
	String accountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

}
