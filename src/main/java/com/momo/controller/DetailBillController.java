package com.momo.controller;

import com.momo.model.BillModel;
import com.momo.model.ProductModel;
import com.momo.repository.DetailBillService;
import com.momo.service.impl.DetailBillServiceImpl;

public class DetailBillController {
	DetailBillService detailBillService = new DetailBillServiceImpl();

	public boolean checkMoney(BillModel billModel, ProductModel productModel) {
		return detailBillService.checkMoney(billModel, productModel);
	}

	public void addQuantityOfDetailBill(BillModel billModel, ProductModel productModel) {
		detailBillService.addQuantityOfDetailBill(billModel, productModel);
	}

	public Long getRefundOfBill(BillModel billModel, ProductModel productModel) {
		return detailBillService.getRefundOfBill(billModel, productModel);
	}

}
