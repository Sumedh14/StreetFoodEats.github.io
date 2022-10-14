package com.demo.controller;

import java.util.List;
import java.util.Optional;

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

import com.demo.beans.Customer;
import com.demo.service.CustomerService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	 CustomerService customerService;
	
	@GetMapping("/")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		 List<Customer> plist=customerService.displayAllCustomer();
		 if(plist.size() <= 0) {
			 return ResponseEntity.notFound().build();
		 }
		 return new ResponseEntity<>(plist,HttpStatus.OK);
		
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId){
		Optional<Customer> c=customerService.getCustomerById(customerId);
		if(c.isPresent()) {
			 return new ResponseEntity<>(c.get(),HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addcustomer(@RequestBody Customer customer){
		System.out.println(customer);
		Customer customer1=customerService.addCustomer(customer);
		System.out.println(customer1);
		if(customer1 != null) {
			return new ResponseEntity<>(customer1,HttpStatus.CREATED);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customer> updatecustomer(@RequestBody Customer customer){
		Customer customer1=customerService.updateById(customer);
		if(customer1 != null) {
			return new ResponseEntity<>(customer1,HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable int customerId){
		customerService.deleteCustomerById(customerId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
