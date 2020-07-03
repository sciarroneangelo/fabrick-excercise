package dev.asciarrone.fabricktest.apiclient.apiobject;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
public class CreditorApiObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6711790184525382874L;

	String name;
	AdrressApiobject address;
	AccountApiObject account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AdrressApiobject getAddress() {
		return address;
	}

	public void setAddress(AdrressApiobject address) {
		this.address = address;
	}

	public AccountApiObject getAccount() {
		return account;
	}

	public void setAccount(AccountApiObject account) {
		this.account = account;
	}

}
