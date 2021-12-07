package com.momo.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.momo.model.ProductModel;

public class PromotionUtils {
	public static Map<ProductModel, Integer> resetPromotion(List<ProductModel> productModels) {
		Map<ProductModel, Integer> mapProducts = new HashMap<ProductModel, Integer>();
		for (ProductModel productModel : productModels) {
			mapProducts.put(productModel, 0);
		}
		return mapProducts;
	}

	public static Map<Integer, ProductModel> getCaseMap(List<ProductModel> productModels) {
		Map<Integer, ProductModel> mapCaseProducts = new HashMap<Integer, ProductModel>();
		for (ProductModel productModel : productModels) {
			mapCaseProducts.put(productModels.indexOf(productModel) + 1, productModel);
		}
		return mapCaseProducts;
	}
}
