package dev.asciarrone.fabricktest.apiclient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dev.asciarrone.fabricktest.apiclient.apiobject.TrasferApiInputObject;
import dev.asciarrone.fabricktest.apiclient.service.BaseService;
import dev.asciarrone.fabricktest.apiclient.service.CreditorService;
import dev.asciarrone.fabricktest.apiclient.service.TrasferService;
import dev.asciarrone.fabricktest.apiclient.service.object.ErrorSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TrasferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TrasferSo;
import dev.asciarrone.fabricktest.handler.MoneyTrasferException;
import dev.asciarrone.fabricktest.mapper.TrasferMapper;

@Service
public class TrasferServiceImpl extends BaseService implements TrasferService {

	private final static String TRASFER_SERVICE_URL = BASE_SERVICE_URL
			+ "accounts/{accountId}/payments/money-transfers ";

	@Autowired
	CreditorService creditorService;

	@Autowired
	TrasferMapper trasferMapper;

	@Override
	public TrasferSo newMoneyTrasfer(TrasferInputSo inputSo) {
		if (inputSo == null) {
			throw new IllegalStateException();
		}
		TrasferSo so = new TrasferSo();
		// Without more specification assume that creditor information not passed by
		// controller and used for call the API are stored in a database
		try {
			inputSo.setCreditor(creditorService.findByName(inputSo.getReceiverName()));
		} catch (Exception ex) {
			creditorNotFoundError(so);
		}
		if (inputSo.getCreditor() == null) {
			creditorNotFoundError(so);
		} else {
			TrasferApiInputObject apiObj = trasferMapper.inputSoToApi(inputSo);
			ObjectMapper mapper = new ObjectMapper();
			String test = null;
			try {
				test = mapper.writeValueAsString(apiObj);
				System.out.println(test);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ResponseEntity<TrasferApiObject> response = null;
			try {
				HttpEntity<String> entity = new HttpEntity<String>(test, httpHeaders);
				response = moneyTrasferRestTemplate.exchange(
						TRASFER_SERVICE_URL.replace("{accountId}", inputSo.getAccountId()), HttpMethod.POST, entity,
						TrasferApiObject.class);
				so = trasferMapper.apiToSo(response.getBody());
			} catch (Exception ex) {
				if (ex.getCause().getClass().equals(MoneyTrasferException.class)) {

					so.setStatus("KO");
					so.getErrors().add(
							new ErrorSo("API000", "Errore tecnico  La condizione BP049 non e' prevista per il conto id "
									+ inputSo.getAccountId()));
				}
			}

		}
		return so;

	}

	private void creditorNotFoundError(TrasferSo so) {
		so.setStatus("KO");
		so.getErrors().add(new ErrorSo("CR0001",
				"Can finde creditor, if you alredy insert in the registry, please contact customer service."));
	}

}
