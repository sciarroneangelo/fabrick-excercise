package dev.asciarrone.fabricktest.mapper;

import java.text.ParseException;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Component;

import dev.asciarrone.fabricktest.apiclient.apiobject.AccountApiObject;
import dev.asciarrone.fabricktest.apiclient.apiobject.AdrressApiobject;
import dev.asciarrone.fabricktest.apiclient.apiobject.CreditorApiObject;
import dev.asciarrone.fabricktest.apiclient.apiobject.TransferApiInputObject;
import dev.asciarrone.fabricktest.apiclient.service.impl.TransferApiObject;
import dev.asciarrone.fabricktest.apiclient.service.object.ErrorSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TransferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TransferSo;
import dev.asciarrone.fabricktest.controller.viewobject.ErrorVo;
import dev.asciarrone.fabricktest.controller.viewobject.TransferInputDataVo;
import dev.asciarrone.fabricktest.controller.viewobject.TransferVo;
import dev.asciarrone.fabricktest.exception.BadDateException;

@Component
public class TransferMapper extends BaseMapper {

	public TransferInputSo inputVotoInputSo(@Valid TransferInputDataVo inputVo) {
		try {
			TransferInputSo inputSo = new TransferInputSo();
			inputSo.setAccountId(inputVo.getAccountId());
			inputSo.setAmount(inputVo.getAmount());
			inputSo.setCurrency(inputVo.getCurrency());
			inputSo.setDescription(inputVo.getDescription());
			inputSo.setExecutionDate(viewDateFormat.parse(inputVo.getExecutionDate()));
			inputSo.setReceiverName(inputVo.getReceiverName());
			return inputSo;
		} catch (ParseException e) {
			throw new BadDateException("Please Check date Format");
		}

	}

	public TransferVo soToVo(TransferSo so) {
		TransferVo vo = new TransferVo();

		// TODO: manage with a specific mapper.
		vo.setErrors(new ArrayList<ErrorVo>());
		so.getErrors().forEach((e) -> {
			vo.getErrors().add(new ErrorVo(e.getCode(), e.getDescription()));
		});
		vo.setStatus(so.getStatus());

		return vo;
	}

	public TransferApiInputObject inputSoToApi(TransferInputSo inputSo) {
		TransferApiInputObject apiObj = new TransferApiInputObject();

		CreditorApiObject crApiObj = new CreditorApiObject();
		crApiObj.setName(inputSo.getReceiverName());

		AccountApiObject acApiObj = new AccountApiObject();
		acApiObj.setAccountCode(inputSo.getCreditor().getAccountCode());
		acApiObj.setBicCode(inputSo.getCreditor().getBicCode());
		crApiObj.setAccount(acApiObj);

		AdrressApiobject addApiObj = new AdrressApiobject();
		addApiObj.setAddress(inputSo.getCreditor().getAddress());
		addApiObj.setCountryCode(inputSo.getCreditor().getCountyCode());
		addApiObj.setCity(inputSo.getCreditor().getCity());
		crApiObj.setAddress(addApiObj);

		apiObj.setCreditor(crApiObj);

		apiObj.setAmount(inputSo.getAmount());
		apiObj.setCurrency(inputSo.getCurrency());
		apiObj.setDescription(inputSo.getDescription());

		apiObj.setExecutionDate(apiDateFormat.format(inputSo.getExecutionDate()));

		return apiObj;
	}

	public TransferSo apiToSo(TransferApiObject apiObj) {
		TransferSo so = new TransferSo();

		// TODO: manage with a specific mapper.
		so.setErrors(new ArrayList<ErrorSo>());
		apiObj.getErrors().forEach((e) -> {
			so.getErrors().add(new ErrorSo(e.getCode(), e.getDescription()));
		});
		so.setStatus(apiObj.getStatus());

		return so;
	}

}
