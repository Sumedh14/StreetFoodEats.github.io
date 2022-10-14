package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Customer;
import com.demo.beans.User;
import com.demo.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Customer validateCustomerLogin(User user) {
		Customer customer = customerDao.validateCustomer(user.getUserEmail(),user.getPassword());
		if(customer != null) {
			return customer;
		}
		else {
			return null;
		}
	}
	
	@Override
	public Customer addCustomer(Customer customer) {
		try {
			return customerDao.save(customer);
		}catch(IllegalArgumentException e){
			return null;
		}
	}
	
	@Override
	public List<Customer> displayAllCustomer() {
		return customerDao.findAll();
	}
	
	@Override
	public Optional<Customer> getCustomerById(int customerId) {
		Optional<Customer> customer=customerDao.findById(customerId);
		if(customer.isPresent()) {
			System.out.println(customer);
			return customer;
		}else {
			System.out.println("return null");
			return Optional.empty();
		}
	}
	
	@Override
	public void deleteCustomerById(int customerId) {
		customerDao.deleteById(customerId);
	}
	
	@Override
	public Customer updateById(Customer customer) {
		Optional<Customer> customer1=customerDao.findById(customer.getCustomerId());
		if(customer1.isPresent()) {
			Customer customer2=customer1.get();
			customer2.setCustomerName(customer.getCustomerName());
			customer2.setCustomerEmail(customer.getCustomerEmail());
			customer2.setCustomerPassword(customer.getCustomerPassword());
			customer2.setCustomerAddress(customer.getCustomerAddress());
			customer2.setCustomerPhoneNo(customer.getCustomerPhoneNo());
			return customerDao.save(customer2);
		}
		else {
			System.out.println("return null");
			return null;
		}
	}

}
