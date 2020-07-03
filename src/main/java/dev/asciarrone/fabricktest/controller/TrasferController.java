package dev.asciarrone.fabricktest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.asciarrone.fabricktest.apiclient.service.TrasferService;
import dev.asciarrone.fabricktest.apiclient.service.object.TrasferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TrasferSo;
import dev.asciarrone.fabricktest.controller.viewobject.TrasferInputDataVo;
import dev.asciarrone.fabricktest.controller.viewobject.TrasferVo;
import dev.asciarrone.fabricktest.mapper.TrasferMapper;

@RestController
@RequestMapping(BaseAbstractControllerV10.API_PREFIX + "/trasfer")
public class TrasferController {

	@Autowired
	TrasferMapper trasferMapperService;

	@Autowired
	TrasferService trasferService;

	@RequestMapping(value = "/newMoneyTrasfer")
	public @ResponseBody ResponseEntity<TrasferVo> newMoneyTrasfer(@Valid @RequestBody TrasferInputDataVo inputData) {

		TrasferInputSo so = trasferMapperService.inputVotoInputSo(inputData);

		TrasferSo outputSo = trasferService.newMoneyTrasfer(so);
		if (outputSo.getStatus().equals("OK")) {
			return ResponseEntity.ok(trasferMapperService.soToVo(outputSo));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(trasferMapperService.soToVo(outputSo));
		}

	}

}
