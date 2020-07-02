package dev.asciarrone.fabricktest.controller.viewobject;

import java.io.Serializable;
import java.util.Date;

public class BalanceVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8821221324351011438L;
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
