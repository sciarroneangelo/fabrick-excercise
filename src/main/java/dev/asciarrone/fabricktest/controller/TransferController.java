package dev.asciarrone.fabricktest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.asciarrone.fabricktest.apiclient.service.TransferService;
import dev.asciarrone.fabricktest.apiclient.service.object.TransferInputSo;
import dev.asciarrone.fabricktest.apiclient.service.object.TransferSo;
import dev.asciarrone.fabricktest.controller.viewobject.TransferInputDataVo;
import dev.asciarrone.fabricktest.controller.viewobject.TransferVo;
import dev.asciarrone.fabricktest.mapper.TransferMapper;

@RestController
@RequestMapping(BaseAbstractControllerV10.API_PREFIX + "/transfer")
public class TransferController {

	@Autowired
	TransferMapper transferMapper;

	@Autowired
	TransferService transferService;

	@RequestMapping(value = "/newMoneyTransfer")
	public @ResponseBody ResponseEntity<TransferVo> newMoneyTransfer(
			@Valid @RequestBody TransferInputDataVo inputData) {

		TransferInputSo so = transferMapper.inputVotoInputSo(inputData);

		TransferSo outputSo = transferService.newMoneyTransfer(so);
		if (outputSo.getStatus().equals("OK")) {
			return ResponseEntity.ok(transferMapper.soToVo(outputSo));
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(transferMapper.soToVo(outputSo));
		}

	}

}
