package com.momo.entity;

public class ResultOfBuiildEntity {
	private String name;
	private Integer quantity;
	private Integer quantityPrize;
	private Long priceProduct;

	public ResultOfBuiildEntity(String name, Integer quantity, Integer quantityPrize, Long priceProduct) {
		this.name = name;
		this.quantity = quantity;
		this.quantityPrize = quantityPrize;
		this.priceProduct = priceProduct;
	}

	public ResultOfBuiildEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantityPrize() {
		return quantityPrize;
	}

	public void setQuantityPrize(Integer quantityPrize) {
		this.quantityPrize = quantityPrize;
	}

	public Long getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Long priceProduct) {
		this.priceProduct = priceProduct;
	}

	@Override
	public String toString() {
		return "ResultOfBuiildEntity [name=" + name + ", quantity=" + quantity + ", quantityPrize=" + quantityPrize
				+ ", priceProduct=" + priceProduct + "]";
	}

}
