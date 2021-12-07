package com.momo.repository;

import java.util.List;

import com.momo.entity.BillEntity;
import com.momo.entity.ResultOfBuiildEntity;

public interface BillRepository {
	
	void createBillEntity(BillEntity billEntity);

	BillEntity getBillEntityByCreatedDateAndCustMoney(Long createdDate, Long custMoney);

	List<ResultOfBuiildEntity> getResultByBillId(Long billId);
}
