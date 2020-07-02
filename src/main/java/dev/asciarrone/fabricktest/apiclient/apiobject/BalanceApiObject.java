package dev.asciarrone.fabricktest.apiclient.apiobject;

import dev.asciarrone.fabricktest.apiclient.apiobject.payload.BalancePayLoad;

public class BalanceApiObject extends BaseApiObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3944895071482146432L;

	private BalancePayLoad payLoad;

	public BalancePayLoad getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(BalancePayLoad payLoad) {
		this.payLoad = payLoad;
	}

}
