package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Dish;
import com.demo.dao.DishDao;

@Service
public class DishServiceImpl implements DishService {

	@Autowired
	private DishDao dishDao;

	@Override
	public List<Dish> displayAll() {
		return dishDao.findAll();
	}

	@Override
	public Optional<Dish> getById(int id) {
		Optional<Dish> dish = dishDao.findById(id);
		if(dish.isPresent()) {
			return Optional.ofNullable(dish.get());
		}
		else {
			return null;
		}
	}

	@Override
	public Dish addDish(Dish dish) {
		try {
			return dishDao.save(dish);
		}catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public Dish updateDish(Dish dish) {
		Optional<Dish> dish1 = dishDao.findById(dish.getDishId());
		if(dish1.isPresent()) {
			Dish dish2 = dish1.get();
			dish2.setDishName(dish.getDishName());
			dish2.setDescription(dish.getDescription());
			dish2.setPrice(dish.getPrice());
			dish2.setDishImage(dish.getDishImage());
			dish2.setDishCategory(dish.getDishCategory());
			return dishDao.save(dish2);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		dishDao.deleteById(id);
	}

	@Override
	public List<Dish> displayAllByShop(int shopId) {
		return dishDao.findAllByShop(shopId);
	}
	
	
	
}
