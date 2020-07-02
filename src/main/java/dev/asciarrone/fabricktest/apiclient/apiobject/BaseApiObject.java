package dev.asciarrone.fabricktest.apiclient.apiobject;

import java.io.Serializable;
import java.util.List;

public class BaseApiObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3885673207174338224L;
	protected String status;
	// Found two different error array in the response:
	// -- in case of error (http response not 200) is present an array called errors
	// -- in case of corret execution (http response 200) is present an array
	// element called error
	protected List<Error> errors;
	protected List<Error> error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public List<Error> getError() {
		return error;
	}

	public void setError(List<Error> error) {
		this.error = error;
	}

}
