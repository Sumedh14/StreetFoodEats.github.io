package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dish_category")
public class DishCategory {
	
     @Id
	private int dishCategoryId;
	
	private String dishCategoryType;

	public DishCategory() {
		super();
	}
	
	public DishCategory(int dishCategoryId, String dishCategoryType) {
		super();
		this.dishCategoryId = dishCategoryId;
		this.dishCategoryType = dishCategoryType;
	}

	public int getDishCategoryId() {
		return dishCategoryId;
	}

	public void setDishCategoryId(int dishCategoryId) {
		this.dishCategoryId = dishCategoryId;
	}

	public String getDishCategoryType() {
		return dishCategoryType;
	}

	public void setDishCategoryType(String dishCategoryType) {
		this.dishCategoryType = dishCategoryType;
	}

	@Override
	public String toString() {
		return "DishCategory [dishCategoryId=" + dishCategoryId + ", dishCategoryType=" + dishCategoryType + "]";
	}
}
