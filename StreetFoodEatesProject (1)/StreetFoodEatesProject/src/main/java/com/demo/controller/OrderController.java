package com.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.Cart;
import com.demo.beans.DeliveryAgent;
import com.demo.beans.Order;
import com.demo.beans.OrderInfo;
import com.demo.beans.PlaceOrder;
import com.demo.service.DeliveryAgentService;
import com.demo.service.OrderDishService;
import com.demo.service.OrderService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/order")
public class OrderController {

	static LinkedHashSet<Cart> cart; 

	static {
		cart=new LinkedHashSet<Cart>();
	}
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OrderDishService orderDishService;
	
	@Autowired
	DeliveryAgentService deliveryAgentService;
	
	@GetMapping("/liveOrder2/{cId}")
	public ResponseEntity<List<Object>> getAllLiveOrder(@PathVariable int cId){
		
		System.out.println("cId in live order---->"+cId);
		 List<Object> olist=orderService.displayAllOrderByCustomerId(cId);
		 
		 if(olist.size()<=0) {
			 return ResponseEntity.notFound().build();
		 }
		 return new ResponseEntity<>(olist,HttpStatus.OK);
	}
	
	@GetMapping("/liveOrder/{cId}")
	public ResponseEntity<List<Order>> findLiveOrders(@PathVariable int cId){
		
		 List<Order> olist=orderService.findLiveOrders(cId);
		 
		 if(olist.size()<=0) {
			 return ResponseEntity.notFound().build();
		 }
		 return new ResponseEntity<>(olist,HttpStatus.OK);
	}
	
	@GetMapping("/orderHistory/{cId}")
	public ResponseEntity<List<Order>> findOrdersHistory(@PathVariable int cId){
		
		 List<Order> olist=orderService.findOrdersHistory(cId);
		 
		 if(olist.size()<=0) {
			 return ResponseEntity.notFound().build();
		 }
		 return new ResponseEntity<>(olist,HttpStatus.OK);
	}
	
	
	@GetMapping("/orderHistory2/{cId}")
	public ResponseEntity<List<OrderInfo>> getAllOrderHistory(@PathVariable int cId){
		
		 List<OrderInfo> olist=(List<OrderInfo>)(List<?>)orderService.displayAllOrderHistoryByCustomerId(cId);
		 
		 if(olist.size()<=0) {
			 return ResponseEntity.notFound().build();
		 }
		 return new ResponseEntity<>(olist,HttpStatus.OK);
	}
	
	@PutMapping("/cancelorder/{oId}")
	public ResponseEntity<Order> updateProduct(/*@RequestBody Order o*/@PathVariable int oId){
		
		Order o1 = orderService.updateOrderById(oId);
		
		if(o1 != null) {
			return new ResponseEntity<>(o1, HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
				
	}
	
//	@GetMapping("/getorder/{oId}")
//	public ResponseEntity<Order> getOrder(@PathVariable int oId){
//		
//		Order o1 = orderService.getOrderById(oId);
//		System.out.println(o1);
//		return new ResponseEntity<>(o1, HttpStatus.OK);
//		
//		if(o1 != null) {
//			return new ResponseEntity<>(o1, HttpStatus.OK);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//				
//	}
	
	
	
	@PostMapping("/addtocart")
	public ResponseEntity<LinkedHashSet<Cart>> addToCart(@RequestBody Cart c){
		
		//List<Cart> clist = orderService.displayAllproducts();
		cart.add(c);
		if(cart.size()<=0) {
			return ResponseEntity.notFound().build();		
		}else {
			return new ResponseEntity<>(cart,HttpStatus.OK);
			
		}
	}
	
	@GetMapping("/viewcart")
	public ResponseEntity<LinkedHashSet<Cart>> viewCart(){
		
		if(cart.size()<=0) {
			return ResponseEntity.notFound().build();		
		}else {
			return new ResponseEntity<>(cart,HttpStatus.OK);
			
		}
	}
	
	@PostMapping("/placeorder/{cId}")
	public ResponseEntity<List<Order>> placeOrder(@RequestBody List<PlaceOrder> po,@PathVariable int cId){
		 
		//List<Cart> clist = orderService.displayAllproducts();
		if(po.size()>=0) {
			
		
			
			LinkedHashSet<Integer> key = new LinkedHashSet<>();
			for(PlaceOrder e:po) {
				
				e.calculatePriceXQuantity();
				key.add(e.getShopId());
				//System.out.println(key);
				//orderService.placeOrder(e.getCustId(),e.getDishId(),e.getDishName(),e.getDescription(),e.getPrice(),e.getQuantity(),e.getDishImage());
			}
			System.out.println("key :"+key.size());
			List<List<PlaceOrder>> values = new ArrayList<>();
			
			
			Iterator<Integer> itr=key.iterator();
			
			int k=0;
			while(itr.hasNext()) {
				k = itr.next();
				List<PlaceOrder> temp = new ArrayList<>();
				for(PlaceOrder e3:po) {
					   
					   //System.out.println(k);
					  // System.out.println(e3.getShopId());
					   if(k==e3.getShopId()) {
						   temp.add(e3);
					   }
				   }
				values.add(temp);
			}
			
			
			System.out.println("values size "+values.size());
			
			LinkedHashMap<Integer,List<PlaceOrder>> sortorders = new LinkedHashMap<>();
			
			Iterator<Integer> itr2=key.iterator();
		
			for(List<PlaceOrder> e:values) {
				
				if(itr2.hasNext()) {
					sortorders.put(itr2.next(),e);
				}
			}
			
//			LinkedHashMap<Integer,List<PlaceOrder>> sortorders = new LinkedHashMap<>();
//			sortorders.put(2,po);
		
			Set<Map.Entry <Integer,List<PlaceOrder>>> kv = sortorders.entrySet();
			
			
			for(Map.Entry<Integer,List<PlaceOrder>> m:kv) {
				double total=0;
//				m.getValue().stream().forEach(e-> total += e.getPriceXquantity());
				
				for(PlaceOrder e: m.getValue()) {
					
					total += e.getPriceXquantity();
					//if(i==1)
				}
				
//				Date d;
//				long t = d.getTime();
//				GregorianCalendar gc = new GregorianCalendar();
//				gc.setTimeInMillis(t);
//				String time = gc.get(Calendar.HOUR_OF_DAY) +":"+ (gc.get(Calendar.MINUTE)<=9? "0"+gc.get(Calendar.MINUTE):gc.get(Calendar.MINUTE));
				Random r = new Random();
				List<DeliveryAgent> deliveryAgentlist = deliveryAgentService.displayAllDeliveryAgent();
				int index = r.nextInt(deliveryAgentlist.size());
				orderService.saveInOrder(total,cId,m.getKey(),"received",new Date(System.currentTimeMillis()),deliveryAgentlist.get(index).getDeliveryAgentId());
				for(PlaceOrder e: m.getValue()) {
					System.out.println(orderService.getOrderId(cId,m.getKey(),"received"));
					orderDishService.saveInOrderDish(e.getDishId(),orderService.getOrderId(cId,m.getKey(),"received"),e.getQuantity(),e.getPriceXquantity());
				}
			}
			
//				key.add(e.getShopId());
//				orderService.placeOrder(e.getCustId(),e.getDishId(),e.getDishName(),e.getDescription(),e.getPrice(),e.getQuantity(),e.getDishImage());
//			}
			List<Order> olist=orderService.findLiveOrders(cId);
			
			return new ResponseEntity<>(olist,HttpStatus.OK);
					
		}
		else {
			return ResponseEntity.notFound().build();
		}
}
	@GetMapping("/logout")
	public ResponseEntity<LinkedHashSet<Cart>> logout(){
		
		cart.removeAll(cart);
		
		return ResponseEntity.ok().build();		
		
	}
}
