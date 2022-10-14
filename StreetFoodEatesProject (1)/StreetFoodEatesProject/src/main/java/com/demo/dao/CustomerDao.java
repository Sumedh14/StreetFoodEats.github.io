package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.beans.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer>{

	@Query(value = "select * from customer where customer_email= :userEmail and customer_password= :password", nativeQuery=true)
	Customer validateCustomer(@Param("userEmail") String userEmail,@Param("password") String password);
	 
	
}
