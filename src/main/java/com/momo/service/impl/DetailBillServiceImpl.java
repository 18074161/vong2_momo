package com.momo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.momo.entity.BillEntity;
import com.momo.entity.DetailBillEntity;
import com.momo.model.BillModel;
import com.momo.model.DetailBillModel;
import com.momo.model.ProductModel;
import com.momo.repository.BillRepository;
import com.momo.repository.DetailBillRepository;
import com.momo.repository.ProductRepository;
import com.momo.repository.impl.DetailBillRepositoryImpl;
import com.momo.repository.impl.ProductRepositoryImpl;
import com.momo.service.DetailBillService;
import com.momo.service.ProductService;

public class DetailBillServiceImpl implements DetailBillService {
	private DetailBillRepository detailBillRepository = new DetailBillRepositoryImpl();
	private ProductService productService = new ProductServiceImpl();

	@Override
	public void updateDetailBill(DetailBillEntity detailBillEntity) {
	}

	@Override
	public void createBillEntity(DetailBillEntity detailBillEntity) {
	}

	@Override
	public List<DetailBillModel> getListDetailBills(BillModel billModel) {
		List<DetailBillModel> detailBillModels = new ArrayList<DetailBillModel>();
		List<DetailBillEntity> detailBillEntities = new ArrayList<DetailBillEntity>();
		detailBillEntities = detailBillRepository.getDetailBillsByBillIdAndProductId(billModel.getId());
		for (DetailBillEntity detailBillEntity : detailBillEntities) {
			DetailBillModel detailBillModel = new DetailBillModel();
			detailBillModel = convertToDetailBillModel(detailBillEntity);
			detailBillModels.add(detailBillModel);
		}
		return detailBillModels;
	}

	private DetailBillModel convertToDetailBillModel(DetailBillEntity detailBillEntity) {
		DetailBillModel detailBillModel = new DetailBillModel();
		detailBillModel.setBillId(detailBillEntity.getBillId());
		detailBillModel.setProductId(detailBillEntity.getProductId());
		detailBillModel.setQuantity(detailBillEntity.getQuantity());
		detailBillModel.setQuantityPrize(detailBillEntity.getQuantityPrize());
		detailBillModel.setId(detailBillEntity.getId());
		return detailBillModel;
	}

	@Override
	public boolean checkMoney(BillModel billModel, ProductModel productModel) {
		Long priceOfBill = getPriceOfBill(billModel);
		Long customerMoney = billModel.getCustomerMoney();
		Long remainingMoney = customerMoney - priceOfBill;
		if (remainingMoney - productModel.getPrice() < 0) {
			return false;
		}
		return true;
	}

	@Override
	public Long getRefundOfBill(BillModel billModel, ProductModel productModel) {
		Long priceOfBill = getPriceOfBill(billModel);
		Long customerMoney = billModel.getCustomerMoney();
		Long remainingMoney = customerMoney - priceOfBill;
		return remainingMoney;
	}

	@Override
	public Long getPriceOfBill(BillModel billModel) {
		Long sum = 0l;
		List<DetailBillModel> detailBillModels = new ArrayList<DetailBillModel>();
		detailBillModels = getListDetailBills(billModel);
		for (DetailBillModel detailBillModel : detailBillModels) {
			ProductModel productModel = new ProductModel();
			productModel.setId(detailBillModel.getProductId());
			productModel = productService.getProductById(productModel);
			sum += Long.valueOf(detailBillModel.getQuantity()) * productModel.getPrice();
		}
		return sum;
	}

	@Override
	public void addQuantityOfDetailBill(BillModel billModel, ProductModel productModel) {
		DetailBillEntity detailBillEntity = new DetailBillEntity();
		detailBillEntity = detailBillRepository.getByBillIdAndProductId(billModel.getId(), productModel.getId());
		if (detailBillEntity.getBillId() != null) {
			detailBillEntity.setQuantity(detailBillEntity.getQuantity() + 1);
			detailBillRepository.updateDetailBill(detailBillEntity);
		} else {
			detailBillEntity.setBillId(billModel.getId());
			detailBillEntity.setProductId(productModel.getId());
			detailBillEntity.setQuantity(1);
			detailBillEntity.setQuantityPrize(0);
			detailBillRepository.createDetailBillEntity(detailBillEntity);
		}
	}

}
