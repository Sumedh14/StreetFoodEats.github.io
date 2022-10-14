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

import com.demo.beans.Dish;
import com.demo.service.DishService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/dish")
public class DishController {

	@Autowired
	private DishService dishService;
	
	@GetMapping("/alldish")
	public ResponseEntity<List<Dish>> getAllDish() {
		List<Dish> dishlist = dishService.displayAll();
		if(dishlist.size()>=0) {
			return new ResponseEntity<>(dishlist, HttpStatus.OK);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/dish/{id}")
	public ResponseEntity<Dish> getDishById(@PathVariable int id) {
		Optional<Dish> dish = dishService.getById(id);
		if(dish.isPresent()) {
			return new ResponseEntity<>(dish.get(), HttpStatus.OK);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
		
		System.out.println(dish);
		Dish dish1 = dishService.addDish(dish);
		if(dish1 != null) {
			return new ResponseEntity<>(dish1, HttpStatus.CREATED);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Dish> updateDish(@RequestBody Dish dish) {
		Dish dish1 = dishService.updateDish(dish);
		if(dish1 != null) {
			return new ResponseEntity<>(dish1, HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Dish> deleteDish(@PathVariable int id) {
		dishService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	}
	
	@GetMapping("/{shopId}")
	public ResponseEntity<List<Dish>> getAllDishByShop(@PathVariable int shopId) {
		System.out.println("shopId  : "+shopId);
		List<Dish> dishlist = dishService.displayAllByShop(shopId);
		if(dishlist.size() >= 0) {
			return new ResponseEntity<>(dishlist, HttpStatus.OK);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
