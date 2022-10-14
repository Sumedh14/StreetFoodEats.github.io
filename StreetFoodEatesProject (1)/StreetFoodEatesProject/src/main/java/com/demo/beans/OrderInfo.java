package com.demo.beans;

import java.util.Date;

public class OrderInfo {

	private int shopId;
	private int dishId;
	private String dishName;
	private double price;	
	private String description;
	private String dishImage;
	private int deliveryAgentId;
	int orderId;
	String status;
	Date orderReceivedDateAndTime;
	Date dispatchDateAndTime;
	Date deliveryDateAndTime;
	double totalAmount;
	private int customerId;
	int quantity;
	double priceXquantity;
	private String deliveryAgentName;
	private String deliveryAgentPhoneNo;
	private String shopName;
	private String phone;
	private boolean isActive;
	
	public OrderInfo() {
		super();
	}

	public OrderInfo(int shopId, int dishId, String dishName, double price, String description, String dishImage,
			int deliveryAgentId, int orderId, String status, Date orderReceivedDateAndTime, Date dispatchDateAndTime,
			Date deliveryDateAndTime, double totalAmount, int customerId, int quantity, double priceXquantity,
			String deliveryAgentName, String deliveryAgentPhoneNo, String shopName, String phone, boolean isActive) {
		super();
		this.shopId = shopId;
		this.dishId = dishId;
		this.dishName = dishName;
		this.price = price;
		this.description = description;
		this.dishImage = dishImage;
		this.deliveryAgentId = deliveryAgentId;
		this.orderId = orderId;
		this.status = status;
		this.orderReceivedDateAndTime = orderReceivedDateAndTime;
		this.dispatchDateAndTime = dispatchDateAndTime;
		this.deliveryDateAndTime = deliveryDateAndTime;
		this.totalAmount = totalAmount;
		this.customerId = customerId;
		this.quantity = quantity;
		this.priceXquantity = priceXquantity;
		this.deliveryAgentName = deliveryAgentName;
		this.deliveryAgentPhoneNo = deliveryAgentPhoneNo;
		this.shopName = shopName;
		this.phone = phone;
		this.isActive = isActive;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDishImage() {
		return dishImage;
	}

	public void setDishImage(String dishImage) {
		this.dishImage = dishImage;
	}

	public int getDeliveryAgentId() {
		return deliveryAgentId;
	}

	public void setDeliveryAgentId(int deliveryAgentId) {
		this.deliveryAgentId = deliveryAgentId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderReceivedDateAndTime() {
		return orderReceivedDateAndTime;
	}

	public void setOrderReceivedDateAndTime(Date orderReceivedDateAndTime) {
		this.orderReceivedDateAndTime = orderReceivedDateAndTime;
	}

	public Date getDispatchDateAndTime() {
		return dispatchDateAndTime;
	}

	public void setDispatchDateAndTime(Date dispatchDateAndTime) {
		this.dispatchDateAndTime = dispatchDateAndTime;
	}

	public Date getDeliveryDateAndTime() {
		return deliveryDateAndTime;
	}

	public void setDeliveryDateAndTime(Date deliveryDateAndTime) {
		this.deliveryDateAndTime = deliveryDateAndTime;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public String getDeliveryAgentName() {
		return deliveryAgentName;
	}

	public void setDeliveryAgentName(String deliveryAgentName) {
		this.deliveryAgentName = deliveryAgentName;
	}

	public String getDeliveryAgentPhoneNo() {
		return deliveryAgentPhoneNo;
	}

	public void setDeliveryAgentPhoneNo(String deliveryAgentPhoneNo) {
		this.deliveryAgentPhoneNo = deliveryAgentPhoneNo;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "OrderInfo [shopId=" + shopId + ", dishId=" + dishId + ", dishName=" + dishName + ", price=" + price
				+ ", description=" + description + ", dishImage=" + dishImage + ", deliveryAgentId=" + deliveryAgentId
				+ ", orderId=" + orderId + ", status=" + status + ", orderReceivedDateAndTime="
				+ orderReceivedDateAndTime + ", dispatchDateAndTime=" + dispatchDateAndTime + ", deliveryDateAndTime="
				+ deliveryDateAndTime + ", totalAmount=" + totalAmount + ", customerId=" + customerId + ", quantity="
				+ quantity + ", priceXquantity=" + priceXquantity + ", deliveryAgentName=" + deliveryAgentName
				+ ", deliveryAgentPhoneNo=" + deliveryAgentPhoneNo + ", shopName=" + shopName + ", phone=" + phone
				+ ", isActive=" + isActive + "]";
	}

	
}
