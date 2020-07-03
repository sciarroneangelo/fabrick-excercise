package dev.asciarrone.fabricktest.apiclient.service;

import dev.asciarrone.fabricktest.apiclient.service.object.TrasferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TrasferSo;

public interface TrasferService {

	TrasferSo newMoneyTrasfer(TrasferInputSo so);

}
