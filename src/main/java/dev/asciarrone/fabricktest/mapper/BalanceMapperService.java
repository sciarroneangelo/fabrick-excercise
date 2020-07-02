package dev.asciarrone.fabricktest.mapper;

import org.springframework.stereotype.Service;

import dev.asciarrone.fabricktest.apiclient.apiobject.BalanceApiObject;
import dev.asciarrone.fabricktest.apiclient.service.systemobject.BalanceSystemObject;
import dev.asciarrone.fabricktest.controller.viewobject.BalanceVo;

@Service
public class BalanceMapperService {

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
