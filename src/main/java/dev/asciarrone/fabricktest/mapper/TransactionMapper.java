package dev.asciarrone.fabricktest.mapper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.asciarrone.fabricktest.apiclient.apiobject.TransactionApiObject;
import dev.asciarrone.fabricktest.apiclient.service.object.TransactionSo;
import dev.asciarrone.fabricktest.controller.viewobject.TransactionTypeVo;
import dev.asciarrone.fabricktest.controller.viewobject.TransactionVo;
import dev.asciarrone.fabricktest.db.dto.TransactionDto;
import dev.asciarrone.fabricktest.db.dto.TransactionTypeDto;

@Component
public class TransactionMapper extends BaseMapper {

	public List<TransactionSo> apiListToSoList(List<TransactionApiObject> apiObjList) {

		List<TransactionSo> soList = new ArrayList<TransactionSo>();
		apiObjList.forEach((apiObj) -> {
			soList.add(apiToSo(apiObj));
		});

		return soList;
	}

	public TransactionSo apiToSo(TransactionApiObject apiObj) {
		TransactionSo so = new TransactionSo();
		so.setAccountingDate(apiObj.getAccountingDate());
		so.setAmount(apiObj.getAmount());
		so.setCurrency(apiObj.getCurrency());
		so.setDescription(apiObj.getDescription());
		so.setEnumerationType(apiObj.getType().getEnumeration());
		so.setOperationId(apiObj.getOperationId());
		so.setTransactionId(apiObj.getTransactionId());
		so.setValueDate(apiObj.getValueDate());
		so.setValueType(apiObj.getType().getValue());
		return so;
	}

	public List<TransactionVo> soListToVoList(List<TransactionSo> soList) {
		List<TransactionVo> voList = new ArrayList<TransactionVo>();
		soList.forEach((apiObj) -> {
			voList.add(soToVo(apiObj));
		});
		return voList;
	}

	public TransactionVo soToVo(TransactionSo so) {
		TransactionVo vo = new TransactionVo();
		vo.setAccountingDate(so.getAccountingDate());
		vo.setAmount(so.getAmount());
		vo.setCurrency(so.getCurrency());
		vo.setDescription(so.getDescription());

		vo.setOperationId(so.getOperationId());
		vo.setTransactionId(so.getTransactionId());
		vo.setValueDate(so.getValueDate());

		TransactionTypeVo typeVo = new TransactionTypeVo();
		typeVo.setEnumeration(so.getEnumerationType());
		typeVo.setValue(so.getValueType());

		vo.setType(typeVo);

		return vo;
	}

	public TransactionDto soToDto(TransactionSo so) {
		try {
			TransactionDto dto = new TransactionDto();
			dto.setAccountingDate(apiDateFormat.parse(so.getAccountingDate()));
			dto.setAmount(Double.valueOf(so.getAmount()));
			dto.setCurrency(so.getCurrency());
			dto.setDescription(so.getDescription());

			dto.setOperationId(so.getOperationId());
			dto.setId(Long.valueOf(so.getTransactionId()));

			dto.setValueDate(apiDateFormat.parse(so.getValueDate()));

			TransactionTypeDto typeDto = new TransactionTypeDto();
			typeDto.setEnumeration(so.getEnumerationType());
			typeDto.setValue(so.getValueType());

			dto.setType(typeDto);
			return dto;
		} catch (ParseException e) {
			return null;
		}

	}

}
