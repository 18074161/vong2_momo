package com.momo.controller;

import com.momo.model.BillModel;
import com.momo.service.BillService;
import com.momo.service.impl.BillServiceImpl;

public class BillController {
	private BillService billService = new BillServiceImpl();

	public void createBillController(Long sum, Long date) {
		BillModel billModel = new BillModel();
		billModel.setCreatedDate(date);
		billModel.setCustomerMoney(sum);
		billService.createBillModel(billModel);
	}

	public BillModel getBillEntityByCreatedDateAndCustMoney(Long createdDate, Long custMoney) {
		return billService.getBillModelByCreatedDateAndCustMoney(createdDate, custMoney);
	}
}
