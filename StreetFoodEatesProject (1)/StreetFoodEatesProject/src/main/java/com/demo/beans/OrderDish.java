package com.demo.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_dish")
public class OrderDish {
	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="dishId")
//	Dish dish;
//	
//	@ManyToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="orderId")
//	Order order;
	
	@EmbeddedId
	private Oid oid;
	
	int quantity;
	double priceXquantity;
	
	public OrderDish() {
		super();
	}
	
	public OrderDish(/*Dish dish*/Oid o, Order order, int quantity, double priceXquantity) {
		super();
//		this.dish = dish;
//		this.order = order;
		this.oid = o;
		this.quantity = quantity;
		this.priceXquantity = priceXquantity;
	}

//	public Dish getDish() {
//		return dish;
//	}
//	public void setDish(Dish dish) {
//		this.dish = dish;
//	}
//	public Order getOrder() {
//		return order;
//	}
//	public void setOrder(Order order) {
//		this.order = order;
//	}
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public Oid getOid() {
		return oid;
	}

	public void setOid(Oid oid) {
		this.oid = oid;
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
	
	
}
