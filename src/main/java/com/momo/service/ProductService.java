package com.momo.service;

import java.util.List;
import java.util.Map;

import com.momo.entity.ProductEntity;
import com.momo.model.ProductModel;

public interface ProductService {
	
	List<ProductModel> getAllProducts();

	Map<ProductModel, Integer> getMapProducts();

	ProductModel getProductByCode(ProductModel model);

	ProductModel getProductById(ProductModel model);
}
