package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.beans.CheckRole;
import com.demo.beans.Customer;
import com.demo.beans.DeliveryAgent;
import com.demo.beans.ShopInfo;
import com.demo.beans.User;
import com.demo.service.CustomerService;
import com.demo.service.DeliveryAgentService;
import com.demo.service.ShopService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private CustomerService customerService;

	@Autowired
	private ShopService shopService;
	
	@Autowired
	private DeliveryAgentService deliveryAgentService;
	
	@PostMapping("/validate")
	public ResponseEntity<CheckRole> validateUser(@RequestBody User user) {
		CheckRole checkRole = new CheckRole();
		System.out.println(user);
		if(user.getRole().equals("Customer")) {
			Customer customer = customerService.validateCustomerLogin(user);
			if(customer != null) {
				checkRole.setRoleId(1);
				checkRole.setUserId(customer.getCustomerId());
				return new ResponseEntity<>(checkRole, HttpStatus.OK);
			}
			else {
				checkRole.setRoleId(0);
				
				return new ResponseEntity<>(checkRole, HttpStatus.OK);
			}
		}
		else if(user.getRole().equals("Shop Owner")) {
			ShopInfo shop = shopService.validateShopLogin(user);
			if(shop != null) {
				checkRole.setRoleId(2);
				checkRole.setUserId(shop.getShopId());
				return new ResponseEntity<>(checkRole, HttpStatus.OK);
			}
			else {
				checkRole.setRoleId(0);
				return new ResponseEntity<>(checkRole, HttpStatus.OK);
			}
		}
		else if(user.getRole().equals("Delivery Agent")) {
			DeliveryAgent deliveryAgent = deliveryAgentService.validateDeliveryAgentLogin(user);
			if(deliveryAgent != null) {
				checkRole.setRoleId(3);
				checkRole.setUserId(deliveryAgent.getDeliveryAgentId());
				return new ResponseEntity<>(checkRole, HttpStatus.OK);
			}
			else {
				checkRole.setRoleId(0);
				return new ResponseEntity<>(checkRole, HttpStatus.OK);
			}
		}
		else {
			checkRole.setRoleId(0);
			return new ResponseEntity<>(checkRole, HttpStatus.OK);
		}
	}
	
}
