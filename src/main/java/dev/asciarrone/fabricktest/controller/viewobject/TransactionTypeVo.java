package dev.asciarrone.fabricktest.controller.viewobject;

import java.io.Serializable;

//Not use an enum cause i dosn't know all types
public class TransactionTypeVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5571800990882163247L;

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
