package dev.asciarrone.fabricktest.apiclient.apiobject;

import java.io.Serializable;

public class TransactionTypeApiObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3495672089724285334L;

	String enumeration;
	String value;

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
