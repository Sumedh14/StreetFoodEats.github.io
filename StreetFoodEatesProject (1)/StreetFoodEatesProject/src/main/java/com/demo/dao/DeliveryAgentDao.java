package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.beans.DeliveryAgent;

@Repository
public interface DeliveryAgentDao extends JpaRepository<DeliveryAgent, Integer>{

	
	@Query(value = "select * from delivery_agent where delivery_agent_email= :userEmail and delivery_agent_password= :password", nativeQuery=true)

	DeliveryAgent validate(@Param("userEmail") String userEmail, @Param("password") String password);
	
	

}
