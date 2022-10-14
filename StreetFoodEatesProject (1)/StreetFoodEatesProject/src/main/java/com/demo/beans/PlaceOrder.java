package com.demo.beans;

public class PlaceOrder {

	
	private int dishId;
	
	private int shopId;
	
	private double price;
	
	private int quantity;

	///////////////////////////
	
	private double priceXquantity;
	
	public PlaceOrder() {
		super();
		System.out.println("parameterless const of PlaceOrder");
	}

	public PlaceOrder(int dishId, int shopId, double price, int quantity,double priceXquantity) {
		super();
	
		this.dishId = dishId;
		this.shopId = shopId;
		this.price = price;
		this.quantity = quantity;
		this.priceXquantity = priceXquantity;
		System.out.println("parameterized const of PlaceOrder");
	}

	public void calculatePriceXQuantity() {
		
		this.priceXquantity =  price * quantity;
	}
	
	

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPriceXquantity() {
		return priceXquantity;
	}

	public void setPriceXquantity(double priceXquantity) {
		this.priceXquantity = priceXquantity;
	}

	@Override
	public String toString() {
		return "PlaceOrder [dishId=" + dishId + ", shopId=" + shopId + ", price=" + price + ", quantity=" + quantity
				+ ", priceXquantity=" + priceXquantity + "]";
	}
	
	
}
