package dev.asciarrone.fabricktest.db.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "transaction")
public class TransactionDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6131592823280374525L;

	@Id
	@Column(name = "tr_id")
	Long Id;

	@Column(name = "tr_operationId")
	String operationId;

	@Column(name = "tr_accountingDate")
	Date accountingDate;

	@Column(name = "tr_valueDate")
	Date valueDate;

	@Column(name = "tr_amount")
	Double amount;

	@Column(name = "tr_currency")
	String currency;

	@Column(name = "tr_description")
	String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tr_type")
	@Fetch(FetchMode.JOIN)
	TransactionTypeDto type;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getOperationId() {
		return operationId;
	}

	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}

	public Date getAccountingDate() {
		return accountingDate;
	}

	public void setAccountingDate(Date accountingDate) {
		this.accountingDate = accountingDate;
	}

	public Date getValueDate() {
		return valueDate;
	}

	public void setValueDate(Date valueDate) {
		this.valueDate = valueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TransactionTypeDto getType() {
		return type;
	}

	public void setType(TransactionTypeDto type) {
		this.type = type;
	}

}
