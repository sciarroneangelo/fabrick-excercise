package dev.asciarrone.fabricktest.apiclient.service;

import dev.asciarrone.fabricktest.apiclient.service.object.CreditorSo;

public interface CreditorService {

	CreditorSo findByName(String receiverName);

}
