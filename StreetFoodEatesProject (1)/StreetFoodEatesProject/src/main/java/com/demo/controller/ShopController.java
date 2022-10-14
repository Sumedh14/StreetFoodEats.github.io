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

import com.demo.beans.ShopInfo;
import com.demo.beans.User;
import com.demo.service.ShopService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/shopes") // change fro shopes here and in register in react
public class ShopController {

	@Autowired
	private ShopService shopService;
	
//	@GetMapping("/validate")
//	public ResponseEntity<ShopInfo> validateShop(@RequestBody User user) {
//		ShopInfo shop = shopService.validateShopLogin(user);
//		if(shop != null) {
//			return new ResponseEntity<>(shop, HttpStatus.OK);
//		}
//		else {
//			return ResponseEntity.notFound().build();
//		}
//	}
	
	@GetMapping("/shop")
	public ResponseEntity<List<ShopInfo>> getAllShopInfo() {
		List<ShopInfo> shoplist = shopService.displayAll();
		if(shoplist.size()>=0) {
			return new ResponseEntity<>(shoplist, HttpStatus.OK);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ShopInfo> getShopInfoById(@PathVariable int id) {
		Optional<ShopInfo> shop = shopService.getById(id);
		if(shop.isPresent()) {
			return new ResponseEntity<>(shop.get(), HttpStatus.OK);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/shop")
	public ResponseEntity<ShopInfo> addShopInfo(@RequestBody ShopInfo shop) {
		System.out.println(shop);
		System.out.println(shop.getImage()); 
		ShopInfo shop1 = shopService.addShop(shop);
		//System.out.println(shop1);
		if(shop1 != null) {
			return new ResponseEntity<>(shop1, HttpStatus.CREATED);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ShopInfo> updateShop(@RequestBody ShopInfo shop, @PathVariable int id) {
		shop.setShopId(id);
		ShopInfo shop1 = shopService.updateShop(shop);
		if(shop1 != null) {
			return new ResponseEntity<>(shop1, HttpStatus.OK);
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ShopInfo> deleteShop(@PathVariable int id) {
		shopService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
	}
	
	
	/*
	 * //not working yet
	 * 
	 * @PutMapping("/resetPassword") public ResponseEntity<ShopInfo>
	 * updateShopPassword( @RequestParam String oldPassword, @RequestParam String
	 * newPassword, @RequestParam (name = "id", required = true) int id) { ShopInfo
	 * shop1 = shopService.updateShopPassword(id, oldPassword, newPassword);
	 * if(shop1 != null) { return new ResponseEntity<>(shop1, HttpStatus.OK); } else
	 * { return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
	 */
	
}
