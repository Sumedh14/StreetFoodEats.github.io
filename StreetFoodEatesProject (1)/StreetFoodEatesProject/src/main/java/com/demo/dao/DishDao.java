package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.beans.Dish;

@Repository
public interface DishDao extends JpaRepository<Dish, Integer> {

	@Query(value = "select * from dish where shop_id = :shopId", nativeQuery=true)
	List<Dish> findAllByShop(@Param("shopId") int shopId);

}
