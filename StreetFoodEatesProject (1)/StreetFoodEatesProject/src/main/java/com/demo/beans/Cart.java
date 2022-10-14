package com.demo.beans;

public class Cart {

	private int custId;
	
	private int dishId;
	
	private int shopId;
	
	private String dishName;
	
	private String description;
	
	private double price;
	
	private String dishImage;
	
	private int quantity;

	public Cart() {
		super();
	}

	public Cart(int shopId,int custId,int dishId, String dishName, String description, double price, String dishImage, int quantity) {
		super();
		this.custId = custId;
		this.dishId = dishId;
		this.shopId = shopId;
		this.price = price;
		
		this.dishName = dishName;
		this.description = description;
		
		this.dishImage = dishImage;
		this.quantity = quantity;
	}

	
	
	@Override
	public int hashCode() {
		
		return dishId;
	}

	@Override
	public boolean equals(Object obj) {
		if(dishId!=((Cart)obj).dishId) {
			return false;
		}
		return true;
	}

	
	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDishImage() {
		return dishImage;
	}

	public void setDishImage(String dishImage) {
		this.dishImage = dishImage;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
