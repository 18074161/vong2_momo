package com.momo.entity;

import java.util.Date;

public class PromotionEntity {
	private Long id;
	private Date date;
	private Integer chace;
	private Long budget;

	public PromotionEntity(Long id, Date date, Integer chace, Long budget) {
		super();
		this.id = id;
		this.date = date;
		this.chace = chace;
		this.budget = budget;
	}

	public PromotionEntity() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getChace() {
		return chace;
	}

	public void setChace(Integer chace) {
		this.chace = chace;
	}

	public Long getBudget() {
		return budget;
	}

	public void setBudget(Long budget) {
		this.budget = budget;
	}

	@Override
	public String toString() {
		return "PromotionEntity [id=" + id + ", date=" + date + ", chace=" + chace + ", budget=" + budget + "]";
	}

}
