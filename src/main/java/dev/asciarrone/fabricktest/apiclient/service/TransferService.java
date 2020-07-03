package dev.asciarrone.fabricktest.apiclient.service;

import dev.asciarrone.fabricktest.apiclient.service.object.TransferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TransferSo;

public interface TransferService {

	TransferSo newMoneyTransfer(TransferInputSo so);

}
