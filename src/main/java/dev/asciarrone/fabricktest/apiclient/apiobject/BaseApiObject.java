package dev.asciarrone.fabricktest.apiclient.apiobject;

import java.io.Serializable;

public class BaseApiObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3885673207174338224L;
	protected String status;
	protected Error error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

}
