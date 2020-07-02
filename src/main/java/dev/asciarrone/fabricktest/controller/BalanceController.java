package dev.asciarrone.fabricktest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.asciarrone.fabricktest.apiclient.service.BalanceService;
import dev.asciarrone.fabricktest.controller.viewobject.BalanceInputDataVo;
import dev.asciarrone.fabricktest.controller.viewobject.BalanceVo;
import dev.asciarrone.fabricktest.mapper.BalanceMapperService;

@RestController
@RequestMapping(BaseAbstractControllerV10.API_PREFIX + "/balance")
public class BalanceController extends BaseAbstractControllerV10 {

	@Autowired
	BalanceService balanceService;

	@Autowired
	BalanceMapperService balanceMapperService;

	@RequestMapping(value = "/getLastBalance")
	public @ResponseBody BalanceVo balanceReading(@RequestBody BalanceInputDataVo inputData) {

		return balanceMapperService.soToVo(balanceService.readBalance(inputData.getAccountId()));
	}

}
