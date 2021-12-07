package com.momo.entity;

public class BillEntity {
	private Long id;
	private Long CustomerMoney;
	private Long createdDate;
	
	public BillEntity(Long id, Long customerMoney, Long createdDate) {
		this.id = id;
		CustomerMoney = customerMoney;
		this.createdDate = createdDate;
	}
	
	public BillEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerMoney() {
		return CustomerMoney;
	}

	public void setCustomerMoney(Long customerMoney) {
		CustomerMoney = customerMoney;
	}

	public Long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Long createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "BillEntity [id=" + id + ", CustomerMoney=" + CustomerMoney + ", createdDate=" + createdDate + "]";
	}
	
}
