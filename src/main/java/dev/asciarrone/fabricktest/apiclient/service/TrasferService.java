package dev.asciarrone.fabricktest.apiclient.service;

import dev.asciarrone.fabricktest.apiclient.service.systemobject.TrasferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.systemobject.TrasferSo;

public interface TrasferService {

	TrasferSo newMoneyTrasfer(TrasferInputSo so);

}
