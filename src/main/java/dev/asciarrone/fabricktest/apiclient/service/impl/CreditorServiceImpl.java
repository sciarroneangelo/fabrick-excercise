package dev.asciarrone.fabricktest.apiclient.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.asciarrone.fabricktest.apiclient.service.CreditorService;
import dev.asciarrone.fabricktest.apiclient.service.object.CreditorSo;
import dev.asciarrone.fabricktest.db.repository.CreditorRepository;
import dev.asciarrone.fabricktest.mapper.CreditorMapper;

@Service
public class CreditorServiceImpl implements CreditorService {

	@Autowired
	CreditorRepository creditorRepository;

	@Autowired
	CreditorMapper creditorMapper;

	@Override
	public CreditorSo findByName(String receiverName) {

		return creditorMapper.dtoToSo(creditorRepository.findByName(receiverName));

	}

}
