package dev.asciarrone.fabricktest.db.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "creditor")
public class CreditorDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2698259401007521540L;

	@Id
	@Column(name = "cr_id", unique = true, nullable = false)
	Long id;

	@Column(name = "cr_name", unique = true, nullable = false)
	String name;

	@Column(name = "cr_account_code")
	String accountCode;

	@Column(name = "cr_bic_code")
	String bicCode;

	@Column(name = "cr_address")
	String address;

	@Column(name = "cr_city")
	String city;

	@Column(name = "cr_countryCode")
	String countyCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
