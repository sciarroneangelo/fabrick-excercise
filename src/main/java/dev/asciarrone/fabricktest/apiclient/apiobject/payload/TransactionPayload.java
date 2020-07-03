package dev.asciarrone.fabricktest.apiclient.apiobject.payload;

import java.io.Serializable;
import java.util.List;

import dev.asciarrone.fabricktest.apiclient.apiobject.TransactionApiObject;

public class TransactionPayload implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6486797313030975812L;
	List<TransactionApiObject> list;

	public List<TransactionApiObject> getList() {
		return list;
	}

	public void setList(List<TransactionApiObject> list) {
		this.list = list;
	}

}
