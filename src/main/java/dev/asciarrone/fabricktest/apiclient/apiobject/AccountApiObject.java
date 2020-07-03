package dev.asciarrone.fabricktest.apiclient.apiobject;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class AccountApiObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5940809507384956993L;

	String accountCode;
	String bicCode;

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getBicCode() {
		return bicCode;
	}

	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}

}
