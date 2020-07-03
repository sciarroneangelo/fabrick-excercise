package dev.asciarrone.fabricktest.mapper;

import org.springframework.stereotype.Component;

import dev.asciarrone.fabricktest.apiclient.apiobject.BalanceApiObject;
import dev.asciarrone.fabricktest.apiclient.service.object.BalanceSystemObject;
import dev.asciarrone.fabricktest.controller.viewobject.BalanceVo;

@Component
public class BalanceMapper {

	public BalanceVo soToVo(BalanceSystemObject so) {
		BalanceVo vo = new BalanceVo();
		vo.setAvailableBalance(so.getAvailableBalance());
		vo.setBalance(so.getBalance());
		vo.setCurrency(so.getCurrency());
		vo.setDate(so.getDate());

		return vo;

	}

	public BalanceSystemObject ApiToSo(BalanceApiObject apio) {
		BalanceSystemObject so = new BalanceSystemObject();
		so.setAvailableBalance(apio.getPayload().getAvailableBalance());
		so.setBalance(apio.getPayload().getAvailableBalance());
		so.setCurrency(apio.getPayload().getCurrency());
		so.setDate(apio.getPayload().getDate());
		return so;
	}

}
