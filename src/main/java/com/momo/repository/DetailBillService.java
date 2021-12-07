package com.momo.repository;

import java.util.List;

import com.momo.entity.DetailBillEntity;
import com.momo.model.BillModel;
import com.momo.model.DetailBillModel;
import com.momo.model.ProductModel;

public interface DetailBillService {
	
	List<DetailBillModel> getListDetailBills(BillModel billModel);

	void updateDetailBill(DetailBillEntity detailBillEntity);

	void createBillEntity(DetailBillEntity detailBillEntity);

	boolean checkMoney(BillModel billModel, ProductModel productModel);

	Long getPriceOfBill(BillModel billModel);

	void addQuantityOfDetailBill(BillModel billModel, ProductModel productModel);

	public Long getRefundOfBill(BillModel billModel, ProductModel productModel);
}
