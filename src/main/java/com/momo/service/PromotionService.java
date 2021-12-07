package com.momo.service;

import com.momo.model.PromotionModel;

public interface PromotionService {
	
	PromotionModel getPromotion();

	void updatePromotion(PromotionModel promotionModel);
}
