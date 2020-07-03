package dev.asciarrone.fabricktest.apiclient.service.object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TrasferSo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1789880402936714717L;

	List<ErrorSo> errors;
	String status;

	public List<ErrorSo> getErrors() {
		if (errors == null)
			errors = new ArrayList<ErrorSo>();
		return errors;
	}

	public void setErrors(List<ErrorSo> errors) {
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
