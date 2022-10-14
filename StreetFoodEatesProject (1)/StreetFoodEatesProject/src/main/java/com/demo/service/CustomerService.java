package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.Customer;
import com.demo.beans.User;

public interface CustomerService {

	Customer addCustomer(Customer c);

	List<Customer> displayAllCustomer();
	
	Optional<Customer> getCustomerById(int customerId);

	void deleteCustomerById(int customerId);

	Customer updateById(Customer c);

	Customer validateCustomerLogin(User user);


}
