package dev.asciarrone.fabricktest.apiclient.service;

import dev.asciarrone.fabricktest.apiclient.service.systemobject.BalanceSystemObject;

public interface BalanceService {

	/**
	 * Get the accountid and return the amount of balance
	 * 
	 * @param: accountId
	 * @return: BalanceSystemObject with the amount of balance
	 * 
	 */
	BalanceSystemObject readBalance(String accountId);

}
