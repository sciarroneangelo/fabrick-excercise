package dev.asciarrone.fabricktest.apiclient.apiobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import dev.asciarrone.fabricktest.apiclient.apiobject.payload.BalancePayLoad;

@JsonInclude(content = Include.NON_NULL)
public class BalanceApiObject extends BaseApiObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3944895071482146432L;

	private BalancePayLoad payload;

	public BalancePayLoad getPayload() {
		return payload;
	}

	public void setPayload(BalancePayLoad payload) {
		this.payload = payload;
	}

}
