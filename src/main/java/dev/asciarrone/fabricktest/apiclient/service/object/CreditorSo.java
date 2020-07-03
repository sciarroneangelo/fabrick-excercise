package dev.asciarrone.fabricktest.apiclient.service.object;

import java.io.Serializable;

public class CreditorSo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6978539432426645256L;
	String name;
	String accountCode;
	String bicCode;
	String address;
	String city;
	String countyCode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountyCode() {
		return countyCode;
	}

	public void setCountyCode(String countyCode) {
		this.countyCode = countyCode;
	}

}
