package com.momo.controller;

import java.util.List;
import java.util.Map;

import com.momo.model.BillModel;
import com.momo.model.ProductModel;
import com.momo.service.Service;
import com.momo.service.impl.ServiceImpl;

public class ServiceController {
	Service service = new ServiceImpl();
	
	public Map<ProductModel, Integer> getMapCombo(ProductModel model, List<ProductModel> productModels, Map<ProductModel, Integer> mapProducts) {
		return service.getMapCombo(model, productModels, mapProducts);
	}
	
	boolean checkInputMoney(Long money) {
		return service.checkInputMoney(money);
	}
	
	public void printBill(BillModel billModel, ProductModel productModel) {
		service.printBillByBillId(billModel, productModel);
	}
}
