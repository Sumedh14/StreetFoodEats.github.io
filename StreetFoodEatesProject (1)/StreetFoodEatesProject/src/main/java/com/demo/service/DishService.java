package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.Dish;

public interface DishService {

	List<Dish> displayAll();

	Optional<Dish> getById(int id);

	Dish addDish(Dish dish);

	Dish updateDish(Dish dish);

	void deleteById(int id);

	List<Dish> displayAllByShop(int shopId);

}
