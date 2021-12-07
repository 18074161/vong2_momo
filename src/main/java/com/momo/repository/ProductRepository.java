package com.momo.repository;

import java.util.List;

import com.momo.entity.ProductEntity;

public interface ProductRepository {
	
	List<ProductEntity> getAllProduct();

	ProductEntity getProductByCode(String code);

	ProductEntity getProductById(Long productId);

}
