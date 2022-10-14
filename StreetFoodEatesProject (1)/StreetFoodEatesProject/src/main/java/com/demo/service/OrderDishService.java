package com.demo.service;

public interface OrderDishService {

	void saveInOrderDish(int dishId, int orderId, int quantity, double priceXquantity);

}
