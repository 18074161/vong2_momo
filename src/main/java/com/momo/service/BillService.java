package com.momo.service;

import com.momo.model.BillModel;

public interface BillService {
	
	void createBillModel(BillModel billModel);

	BillModel getBillModelByCreatedDateAndCustMoney(Long createdDate, Long custMoney);
}
