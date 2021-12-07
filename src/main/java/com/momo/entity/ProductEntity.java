package com.momo.entity;

public class ProductEntity {
	private Long id;
	private String name;
	private Long price;
	private String code;

	public ProductEntity(Long id, String name, Long money, String code) {
		this.id = id;
		this.name = name;
		this.price = money;
	}

	public ProductEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long money) {
		this.price = money;
	}

	@Override
	public String toString() {
		return "ProductEntity [id=" + id + ", name=" + name + ", money=" + price + ", code=" + code + "]";
	}

}
