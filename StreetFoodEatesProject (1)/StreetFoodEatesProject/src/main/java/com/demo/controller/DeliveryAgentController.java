package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.demo.beans.DeliveryAgent;
import com.demo.beans.Order;
import com.demo.service.DeliveryAgentService;
import com.demo.service.OrderService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/deliveryAgent")
public class DeliveryAgentController {
	
	@Autowired
	DeliveryAgentService deliveryAgentService;
	
	@Autowired
	OrderService orderService;
	
//	@GetMapping("/receivedOrder/{daId}")
//	public ResponseEntity<List<Object>> getAllDeliveryAgentOrder(@PathVariable int daId){
//		 List<Object> deliveryAgentOrderslist=deliveryAgentService.displayAllDeliveryAgentOrder(daId);
//		 if(deliveryAgentOrderslist.size()<=0) {
//			 return ResponseEntity.notFound().build();
//		 }
//		 return new ResponseEntity<>(deliveryAgentOrderslist,HttpStatus.OK);
//		
//	}
	
	@GetMapping("/receivedOrderV/{daId}")
	public ResponseEntity<List<Order>> getAllDeliveryAgentOrderV(@PathVariable int daId){
		 List<Order> deliveryAgentOrderslist=orderService.displayAllDeliveryAgentOrder(daId);
		 for(Order e :deliveryAgentOrderslist) {
			 System.out.println(e);
		 }
		 if(deliveryAgentOrderslist.size()<=0) {
			 return ResponseEntity.notFound().build();
		 }
		 return new ResponseEntity<>(deliveryAgentOrderslist,HttpStatus.OK);
		
	}
	
	@PutMapping("/dispatchOrder/{oId}")
	public ResponseEntity<Order> updateStatusToDispatched(@PathVariable int oId){
		
		Order o1 = orderService.updatetoDispatch(oId);
		
		if(o1 != null) {
			return new ResponseEntity<>(o1, HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	
	@PutMapping("/deliverOrder/{oId}")
	public ResponseEntity<Order> updateStatusToDelivered(@PathVariable int oId){
		
		Order o1 = orderService.updatetoDelivered(oId);
		
		if(o1 != null) {
			return new ResponseEntity<>(o1, HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	
	@GetMapping("/")
	public ResponseEntity<List<DeliveryAgent>> getAllDeliveryAgent(){
		 List<DeliveryAgent> deliveryAgentlist=deliveryAgentService.displayAllDeliveryAgent();
		 if(deliveryAgentlist.size()<=0) {
			 return ResponseEntity.notFound().build();
		 }
		 return new ResponseEntity<>(deliveryAgentlist,HttpStatus.OK);
		
	}

	@PostMapping("/agent")
	public ResponseEntity<DeliveryAgent> addDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent){
		DeliveryAgent deliveryAgent1=deliveryAgentService.addDeliveryAgent(deliveryAgent);
		
		if(deliveryAgent1!=null) {
			return new ResponseEntity<>(deliveryAgent1,HttpStatus.CREATED);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{deliveryAgentId}")
	public ResponseEntity<DeliveryAgent> deleteDeliveryAgent(@PathVariable int DeliveryAgentId){
		deliveryAgentService.deleteDeliveryAgentById(DeliveryAgentId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{DeliveryAgentId}")
	public ResponseEntity<DeliveryAgent> updateDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent){
		DeliveryAgent deliveryAgent1=deliveryAgentService.updateById(deliveryAgent);
		
		if(deliveryAgent1!=null) {
			return new ResponseEntity<>(deliveryAgent1,HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
