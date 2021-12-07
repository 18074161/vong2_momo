package com.momo.repository;

import com.momo.entity.PromotionEntity;

public interface PromotionRepository {

	public PromotionEntity getPromotion();

	public void updatePromotion(PromotionEntity promotionEntity);

}
