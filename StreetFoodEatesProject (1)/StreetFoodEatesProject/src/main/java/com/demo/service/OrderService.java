package com.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Random;

import com.demo.beans.Order;
import com.demo.beans.OrderInfo;

public interface OrderService {


	List<Object> displayAllOrderByCustomerId(int i);

	List<Object> displayAllOrderHistoryByCustomerId(int i);

	//Order updateOrderById(Order o);

	int getOrderId(int cId, Integer key, String string);

	

	void saveInOrder(double total, int cId, Integer shopId, String status, Date date,int daId);

	Order getOrderById(int oId);

	Order updateOrderById(int oId);

	Order updatetoDispatch(int oId);

	Order updatetoDelivered(int oId);

	List<Order> displayAllDeliveryAgentOrder(int daId);

	List<Order> findLiveOrders(int cId);

	List<Order> findOrdersHistory(int cId);


	
	

}
