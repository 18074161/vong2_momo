package com.momo.entity;

public class DetailBillEntity {
	private Long id;
	private Long productId;
	private Long billId;
	private Integer quantity;
	private Integer quantityPrize;
	
	public DetailBillEntity(Long id, Long productId, Long billId, Integer quantity, Integer quantityPrize) {
		this.id = id;
		this.productId = productId;
		this.billId = billId;
		this.quantity = quantity;
		this.quantityPrize = quantityPrize;
	}
	
	public DetailBillEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getProductId() {
		return productId;
	}
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public Long getBillId() {
		return billId;
	}
	
	public void setBillId(Long billId) {
		this.billId = billId;
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
	
	@Override
	public String toString() {
		return "DetailBillEntity [id=" + id + ", productId=" + productId + ", billId=" + billId + ", quantity="
				+ quantity + ", quantityPrize=" + quantityPrize + "]";
	}
	
}
