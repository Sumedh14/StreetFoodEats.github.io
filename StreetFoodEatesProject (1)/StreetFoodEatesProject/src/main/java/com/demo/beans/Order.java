package com.demo.beans;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="order_1")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "orderId")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int orderId;
	String status;
	Date orderReceivedDateAndTime;
	Date dispatchDateAndTime;
	Date deliveryDateAndTime;
	double totalAmount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="deliveryAgentId")
	DeliveryAgent deliveryAgent;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="shopId")
	ShopInfo shop;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customerId")
	Customer customer;

	public Order() {
		super();
	}

	public Order(String status, Date orderReceivedDateAndTime, Date dispatchDateAndTime, Date deliveryDateAndTime,
			double totalAmount, DeliveryAgent deliveryAgent, ShopInfo shop, Customer customer) {
		super();
		this.status = status;
		this.orderReceivedDateAndTime = orderReceivedDateAndTime;
		this.dispatchDateAndTime = dispatchDateAndTime;
		this.deliveryDateAndTime = deliveryDateAndTime;
		this.totalAmount = totalAmount;
		this.deliveryAgent = deliveryAgent;
		this.shop = shop;
		this.customer = customer;
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

	public DeliveryAgent getDeliveryAgent() {
		return deliveryAgent;
	}

	public void setDeliveryAgent(DeliveryAgent deliveryAgent) {
		this.deliveryAgent = deliveryAgent;
	}

	public ShopInfo getShop() {
		return shop;
	}

	public void setShop(ShopInfo shop) {
		this.shop = shop;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", status=" + status + ", orderReceivedDateAndTime="
				+ orderReceivedDateAndTime + ", dispatchDateAndTime=" + dispatchDateAndTime + ", deliveryDateAndTime="
				+ deliveryDateAndTime + ", totalAmount=" + totalAmount + ", deliveryAgent=" + deliveryAgent + ", shop="
				+ shop + ", customer=" + customer + "]";
	}

	
	
	
}
