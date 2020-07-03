package dev.asciarrone.fabricktest.controller.viewobject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransferVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4584090158480640999L;

	List<ErrorVo> errors;
	String status;

	public List<ErrorVo> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorVo> errors) {
		if (errors == null)
			errors = new ArrayList<ErrorVo>();
		this.errors = errors;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
