package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.beans.ShopInfo;

@Repository
public interface ShopDao extends JpaRepository<ShopInfo, Integer> {
	
	@Query(value = "select * from shop_info_table where email= :userEmail and password= :password", nativeQuery=true)
	ShopInfo validate(@Param("userEmail") String userEmail, @Param("password") String password);
	 
}
