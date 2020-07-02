package dev.asciarrone.fabricktest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.asciarrone.fabricktest.apiclient.service.TrasferService;
import dev.asciarrone.fabricktest.apiclient.service.systemobject.TrasferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.systemobject.TrasferSo;
import dev.asciarrone.fabricktest.controller.viewobject.TrasferInputDataVo;
import dev.asciarrone.fabricktest.controller.viewobject.TrasferVo;
import dev.asciarrone.fabricktest.mapper.TrasferMapperService;

@RestController
@RequestMapping(BaseAbstractControllerV10.API_PREFIX + "/trasfer")
public class TrasferController {

	@Autowired
	TrasferMapperService trasferMapperService;

	@Autowired
	TrasferService trasferService;

	@RequestMapping(value = "/newMoneyTrasfer")
	public @ResponseBody TrasferVo newMoneyTrasfer(@Valid @RequestBody TrasferInputDataVo inputData) {

		TrasferInputSo so = trasferMapperService.inputVotoInputSo(inputData);

		TrasferSo outputSo = trasferService.newMoneyTrasfer(so);

		// TODO create sercvice method and mapper

		return new TrasferVo();

	}

}
