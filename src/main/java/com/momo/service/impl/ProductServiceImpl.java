package com.momo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.momo.entity.ProductEntity;
import com.momo.model.ProductModel;
import com.momo.repository.ProductRepository;
import com.momo.repository.impl.ProductRepositoryImpl;
import com.momo.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository = new ProductRepositoryImpl();

	@Override
	public Map<ProductModel, Integer> getMapProducts() {
		Map<ProductModel, Integer> mapProducts = new HashMap<ProductModel, Integer>();
		List<ProductEntity> entities = new ArrayList<ProductEntity>();
		List<ProductModel> models = new ArrayList<ProductModel>();
		entities = productRepository.getAllProduct();
		models = convertToProductModels(entities);
		for (ProductModel model : models) {
			mapProducts.put(model, 0);
		}
		return mapProducts;
	}

	@Override
	public List<ProductModel> getAllProducts() {
		List<ProductEntity> entities = new ArrayList<ProductEntity>();
		List<ProductModel> models = new ArrayList<ProductModel>();
		entities = productRepository.getAllProduct();
		models = convertToProductModels(entities);

		return models;
	}

	private List<ProductModel> convertToProductModels(List<ProductEntity> entities) {
		List<ProductModel> models = new ArrayList<ProductModel>();
		for (ProductEntity productEntity : entities) {
			ProductModel model = new ProductModel();
			model.setId(productEntity.getId());
			model.setName(productEntity.getName());
			model.setCode(productEntity.getCode());
			model.setPrice(productEntity.getPrice());
			models.add(model);
		}
		return models;
	}

	@Override
	public ProductModel getProductByCode(ProductModel model) {
		ProductModel productModel = new ProductModel();
		ProductEntity productEntity = new ProductEntity();
		productEntity = productRepository.getProductByCode(model.getCode());
		productModel = convertToProductModel(productEntity);
		return productModel;
	}

	private ProductModel convertToProductModel(ProductEntity productEntity) {
		ProductModel model = new ProductModel();
		model.setId(productEntity.getId());
		model.setName(productEntity.getName());
		model.setCode(productEntity.getCode());
		model.setPrice(productEntity.getPrice());
		return model;
	}

	@Override
	public ProductModel getProductById(ProductModel model) {
		ProductModel productModel = new ProductModel();
		ProductEntity productEntity = new ProductEntity();
		productEntity = productRepository.getProductById(model.getId());
		productModel = convertToProductModel(productEntity);
		return productModel;
	}

}
