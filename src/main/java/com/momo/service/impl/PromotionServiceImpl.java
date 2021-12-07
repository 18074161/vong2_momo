package com.momo.service.impl;

import com.momo.entity.PromotionEntity;
import com.momo.model.PromotionModel;
import com.momo.repository.PromotionRepository;
import com.momo.repository.impl.PromotionRepositoryImpl;
import com.momo.service.PromotionService;

public class PromotionServiceImpl implements PromotionService {

	private PromotionRepository promotionRepository = new PromotionRepositoryImpl();

	@Override
	public PromotionModel getPromotion() {
		PromotionEntity entity = new PromotionEntity();
		entity = promotionRepository.getPromotion();
		PromotionModel model = new PromotionModel();
		model = convertToPromotionModel(entity);
		return model;
	}

	private PromotionModel convertToPromotionModel(PromotionEntity entity) {
		PromotionModel model = new PromotionModel();
		model.setId(entity.getId());
		model.setBudget(entity.getBudget());
		model.setChace(entity.getChace());
		model.setDate(entity.getDate());
		return model;
	}

	private PromotionEntity convertToPromotionEntity(PromotionModel promotionModel) {
		PromotionEntity entity = new PromotionEntity();
		entity.setId(promotionModel.getId());
		entity.setBudget(promotionModel.getBudget());
		entity.setChace(promotionModel.getChace());
		entity.setDate(promotionModel.getDate());
		return entity;
	}

	@Override
	public void updatePromotion(PromotionModel promotionModel) {
		PromotionEntity entity = new PromotionEntity();
		entity = convertToPromotionEntity(promotionModel);
		promotionRepository.updatePromotion(entity);

	}

}
