package dev.asciarrone.fabricktest.apiclient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import dev.asciarrone.fabricktest.apiclient.apiobject.BalanceApiObject;
import dev.asciarrone.fabricktest.apiclient.service.BalanceService;
import dev.asciarrone.fabricktest.apiclient.service.BaseService;
import dev.asciarrone.fabricktest.apiclient.service.systemobject.BalanceSystemObject;
import dev.asciarrone.fabricktest.mapper.BalanceMapperService;

@Service
public class BalanceServiceImpl extends BaseService implements BalanceService {

	private final static String BALANCE_SERVICE_URL = BASE_SERVICE_URL + "accounts/{accountId}/balance";

	@Autowired
	BalanceMapperService balanceMapperService;

	@Override
	public BalanceSystemObject readBalance(String accountId) {

		BalanceApiObject apio = restTemplate.exchange(BALANCE_SERVICE_URL.replace("{accountId}", accountId),
				HttpMethod.GET, httpEntity(), BalanceApiObject.class).getBody();

		return balanceMapperService.ApiToSo(apio);
	}

}
