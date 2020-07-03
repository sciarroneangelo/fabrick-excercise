package dev.asciarrone.fabricktest.db.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tr_type")
public class TransactionTypeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4723939161685309721L;

	@Id
	@GeneratedValue
	@Column(name = "trt_id")
	Long id;

	@Column(name = "trt_enumeration")
	String enumeration;

	@Column(name = "trt_value")
	String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEnumeration() {
		return enumeration;
	}

	public void setEnumeration(String enumeration) {
		this.enumeration = enumeration;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
