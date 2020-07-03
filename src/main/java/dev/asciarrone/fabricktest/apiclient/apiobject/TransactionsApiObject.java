package dev.asciarrone.fabricktest.apiclient.apiobject;

import java.io.Serializable;

import dev.asciarrone.fabricktest.apiclient.apiobject.payload.TransactionPayload;

public class TransactionsApiObject extends BaseApiObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8787906884040811937L;

	TransactionPayload payload;

	public TransactionPayload getPayload() {
		return payload;
	}

	public void setPayload(TransactionPayload payload) {
		this.payload = payload;
	}

}
