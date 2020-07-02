package dev.asciarrone.fabricktest.apiclient.service.systemobject;

import java.io.Serializable;
import java.util.Date;

public class BalanceSystemObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6050717941906518126L;
	private Date date;
	private Number balance;
	private Number availableBalance;
	private String currency;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Number getBalance() {
		return balance;
	}

	public void setBalance(Number balance) {
		this.balance = balance;
	}

	public Number getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Number availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
