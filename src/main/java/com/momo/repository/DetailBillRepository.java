package com.momo.repository;

import java.util.List;

import com.momo.entity.DetailBillEntity;

public interface DetailBillRepository {
	
	void updateDetailBill(DetailBillEntity detailBillEntity);

	void createDetailBillEntity(DetailBillEntity detailBillEntity);

	List<DetailBillEntity> getDetailBillByBillIdAndProductId(Long billId, Long productId);

	List<DetailBillEntity> getDetailBillsByBillIdAndProductId(Long billId);

	DetailBillEntity getByBillIdAndProductId(Long billId, Long productId);
}
