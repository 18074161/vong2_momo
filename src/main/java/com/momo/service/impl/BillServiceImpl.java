package com.momo.service.impl;

import com.momo.entity.BillEntity;
import com.momo.model.BillModel;
import com.momo.repository.BillRepository;
import com.momo.repository.impl.BillRepositoryImpl;
import com.momo.service.BillService;

public class BillServiceImpl implements BillService {

	private BillRepository billRepository = new BillRepositoryImpl();

	@Override
	public void createBillModel(BillModel billModel) {
		BillEntity billEntity = new BillEntity();
		billEntity = convertToBillEntity(billModel);
		billRepository.createBillEntity(billEntity);
	}

	private BillEntity convertToBillEntity(BillModel billModel) {
		BillEntity billEntity = new BillEntity();
		billEntity.setCreatedDate(billModel.getCreatedDate());
		billEntity.setCustomerMoney(billModel.getCustomerMoney());
		return billEntity;
	}

	private BillModel convertToBillModel(BillEntity billEntity) {
		BillModel billModel = new BillModel();
		billModel.setId(billEntity.getId());
		billModel.setCreatedDate(billEntity.getCreatedDate());
		billModel.setCustomerMoney(billEntity.getCustomerMoney());
		return billModel;
	}

	@Override
	public BillModel getBillModelByCreatedDateAndCustMoney(Long createdDate, Long custMoney) {
		BillModel billModel = new BillModel();
		BillEntity billEntity = new BillEntity();
		billEntity = billRepository.getBillEntityByCreatedDateAndCustMoney(createdDate, custMoney);
		billModel = convertToBillModel(billEntity);
		return billModel;
	}

}
