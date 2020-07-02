package dev.asciarrone.fabricktest.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import dev.asciarrone.fabricktest.apiclient.service.systemobject.TrasferInputSo;
import dev.asciarrone.fabricktest.controller.viewobject.TrasferInputDataVo;

@Service
public class TrasferMapperService {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

	public TrasferInputSo inputVotoInputSo(@Valid TrasferInputDataVo inputVo) {
		try {
			TrasferInputSo inputSo = new TrasferInputSo();

			inputSo.setAccountId(inputVo.getAccountId());

			inputSo.setAmount(Double.parseDouble(inputVo.getAmount()));

			inputSo.setCurrency(inputVo.getCurrency());

			inputSo.setDescription(inputVo.getCurrency());

			inputSo.setExcutionDate(sdf.parse(inputVo.getExcutionDate()));

			inputSo.setReceiverName(inputVo.getReceiverName());

			return inputSo;
		} catch (ParseException e) {
			return null;
		}

	}

}
