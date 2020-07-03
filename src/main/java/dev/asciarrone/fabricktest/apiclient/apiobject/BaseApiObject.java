package dev.asciarrone.fabricktest.apiclient.apiobject;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(content = Include.NON_NULL)
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
	protected List<ErrorApiObjct> errors;
	protected List<ErrorApiObjct> error;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ErrorApiObjct> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorApiObjct> errors) {
		this.errors = errors;
	}

	public List<ErrorApiObjct> getError() {
		return error;
	}

	public void setError(List<ErrorApiObjct> error) {
		this.error = error;
	}

}
