package com.demo.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Customer;
import com.demo.beans.DeliveryAgent;
import com.demo.beans.Dish;
import com.demo.beans.Oid;
import com.demo.beans.Order;
import com.demo.beans.OrderDish;
import com.demo.beans.OrderInfo;
import com.demo.beans.ShopInfo;
import com.demo.dao.OrderDao;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderDao orderDao;


	@Override
	public List<Object> displayAllOrderByCustomerId(int i) {
		
		return orderDao.getAllOrderByCustomerId(i);
	}


	@Override
	public List<Object> displayAllOrderHistoryByCustomerId(int i) {
		
		return orderDao.getAllOrderHistoryByCustomerId(i);
	}


	@Override
	public Order updateOrderById(int oId) {
		
		Optional<Order> o1 = orderDao.findById(oId);
		
		if(o1.isPresent()) {
			
			Order o2 = o1.get();
			if(o2.getStatus().equals("received")) {
				
				o2.setStatus("cancelled");
				return orderDao.save(o2);
				
			}else {
				
				return null;
			}
		}
		return null;
	}


	@Override
	public int getOrderId(int cId, Integer shopId, String status) {
		
		return orderDao.getOrderId(cId,shopId,status);
	}


	@Override
	public void saveInOrder(double total, int cId, Integer shopId, String status, Date date,int daId) {


		Order o = new Order();
		
		o.setTotalAmount(total);
	
		ShopInfo sf=new ShopInfo();
		
		sf.setShopId(shopId);
		
		o.setShop(sf);
		
		Customer c = new Customer();
		
		c.setCustomerId(cId);
		
		o.setCustomer(c);
	
		o.setStatus(status);
		
		o.setOrderReceivedDateAndTime(date);
		
		DeliveryAgent da = new DeliveryAgent(); 
		
		da.setDeliveryAgentId(daId);
		
		o.setDeliveryAgent(da);
		
		orderDao.save(o);
		
	}


	@Override
	public Order getOrderById(int oId) {
		
		Optional<Order> o = orderDao.findById(oId);
	
		return o.get();
	}


	@Override
	public Order updatetoDispatch(int oId) {
		
		Optional<Order> o1 = orderDao.findById(oId);
		
		
		if(o1.isPresent()) {
			
			Order o2 = o1.get();
			if(o2.getStatus().equals("received")) {
				
				o2.setStatus("dispatched");
				return orderDao.save(o2);
				
			}else {
				
				return null;
			}
		}
		return null;
		
	}	
	
	@Override
	public Order updatetoDelivered(int oId) {
		
		Optional<Order> o1 = orderDao.findById(oId);
		
		
		if(o1.isPresent()) {
			
			Order o2 = o1.get();
			if(o2.getStatus().equals("dispatched")) {
				
				o2.setStatus("delivered");
				return orderDao.save(o2);
				
			}else {
				
				return null;
			}
		}
		return null;
		
	}


	@Override
	public List<Order> displayAllDeliveryAgentOrder(int daId) {
		
		return orderDao.findOrders(daId);
	}


	@Override
	public List<Order> findLiveOrders(int cId) {
		
		return orderDao.findLiveOrders(cId);
	}


	@Override
	public List<Order> findOrdersHistory(int cId) {
		
		return orderDao.findOrdersHistory(cId);
	}	
}
