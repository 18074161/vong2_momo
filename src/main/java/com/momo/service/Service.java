package com.momo.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.momo.model.BillModel;
import com.momo.model.ProductModel;

public interface Service {

	boolean isWinThePrice(int chance, Long price);

	Map<ProductModel, Integer> selectProduct(List<ProductModel> productModels, Map<ProductModel, Integer> mapProducts,
			Scanner scanner, int quantity);

	void print(List<ProductModel> productModels, Map<ProductModel, Integer> mapProducts);

	Map<ProductModel, Integer> getMapCheckPrize(List<ProductModel> productModels,
			Map<ProductModel, Integer> mapProducts);

	Integer getPercent();

	boolean checkInputMoney(Long money);

	Map<ProductModel, Integer> getMapCombo(ProductModel productModel, List<ProductModel> productModels,
			Map<ProductModel, Integer> mapProducts);

	Map<ProductModel, Integer> checkPrize(Map<ProductModel, Integer> mapProducts, ProductModel productModel,
			List<ProductModel> productModels, BillModel billModel);

	void printBillByBillId(BillModel billModel, ProductModel productModel);
}
