package dev.asciarrone.fabricktest.apiclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BaseService {

	public final static String BASE_SERVICE_URL = "https://sandbox.platfr.io/api/gbs/banking/v4.0/";

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	protected RestTemplate moneyTransferRestTemplate;

	@Autowired
	protected HttpHeaders httpHeaders;

}
