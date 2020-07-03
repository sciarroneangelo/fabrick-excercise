package dev.asciarrone.fabricktest.mapper;

import org.springframework.stereotype.Component;

import dev.asciarrone.fabricktest.apiclient.service.object.CreditorSo;
import dev.asciarrone.fabricktest.db.dto.CreditorDto;

@Component
public class CreditorMapper {

	public CreditorSo dtoToSo(CreditorDto dto) {

		CreditorSo so = new CreditorSo();

		so.setAccountCode(dto.getAccountCode());
		so.setAddress(dto.getAddress());
		so.setBicCode(dto.getBicCode());
		so.setCity(dto.getCity());
		so.setCountyCode(dto.getCountyCode());
		so.setName(dto.getName());

		return so;
	}

}
