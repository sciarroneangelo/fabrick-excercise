package dev.asciarrone.fabricktest.apiclient.service.object;

import java.io.Serializable;

public class ErrorSo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -923447115822596229L;

	String code;
	String description;

	public ErrorSo(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
