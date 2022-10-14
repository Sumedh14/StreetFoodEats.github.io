package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Dish;
import com.demo.beans.Oid;
import com.demo.beans.Order;
import com.demo.beans.OrderDish;
import com.demo.dao.OrderDishDao;

@Service
public class OrderDishServiceImpl implements OrderDishService{

	@Autowired
	OrderDishDao orderDishDao;

	@Override
	public void saveInOrderDish(int dishId, int orderId, int quantity, double priceXquantity) {
		
		OrderDish od =new OrderDish();
		
		Oid oid = new Oid();
		
		Order o = new Order();
		
		o.setOrderId(orderId);
		
		oid.setOrder(o);
		
		Dish d = new Dish();
		
		d.setDishId(dishId);
		
		oid.setDish(d);
		
		od.setOid(oid);
		
		od.setQuantity(quantity);
		
		od.setPriceXquantity(priceXquantity);
		
		orderDishDao.save(od);
	}

	

}
