package dev.asciarrone.fabricktest.apiclient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import dev.asciarrone.fabricktest.apiclient.apiobject.BalanceApiObject;
import dev.asciarrone.fabricktest.apiclient.service.BalanceService;
import dev.asciarrone.fabricktest.apiclient.service.BaseService;
import dev.asciarrone.fabricktest.apiclient.service.object.BalanceSystemObject;
import dev.asciarrone.fabricktest.mapper.BalanceMapper;

@Service
public class BalanceServiceImpl extends BaseService implements BalanceService {

	private final static String BALANCE_SERVICE_URL = BASE_SERVICE_URL + "accounts/{accountId}/balance";

	@Autowired
	BalanceMapper balanceMapper;

	@Override
	public BalanceSystemObject readBalance(String accountId) {

		if (accountId == null) {
			throw new IllegalStateException("Account id could not be null");

		}
		try {
			HttpEntity<String> entity = new HttpEntity<String>("body", httpHeaders);
			ResponseEntity<BalanceApiObject> response = restTemplate.exchange(
					BALANCE_SERVICE_URL.replace("{accountId}", accountId), HttpMethod.GET, entity,
					BalanceApiObject.class);

			if (response.getStatusCode() != HttpStatus.OK) {
				throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
						"Exceution error: please check data and retry");
			}
			return balanceMapper.ApiToSo(response.getBody());
		} catch (HttpClientErrorException.Forbidden ex) {
			throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Invalid Account Id");
		}

	}

}
