package com.demo.service;

import java.util.List;
import java.util.Optional;

import com.demo.beans.ShopInfo;
import com.demo.beans.User;

public interface ShopService {
	
	ShopInfo validateShopLogin(User user);

	List<ShopInfo> displayAll();

	Optional<ShopInfo> getById(int id);

	ShopInfo addShop(ShopInfo shop);

	ShopInfo updateShop(ShopInfo shop);

	void deleteById(int id);

	ShopInfo updateShopPassword(int id, String oldPassword, String newPassword);

}
