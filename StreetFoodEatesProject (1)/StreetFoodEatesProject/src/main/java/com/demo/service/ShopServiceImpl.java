package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.ShopInfo;
import com.demo.beans.User;
import com.demo.dao.ShopDao;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDao;
	
	@Override
	public ShopInfo validateShopLogin(User user) {
		ShopInfo shop = shopDao.validate(user.getUserEmail(), user.getPassword());
		if(shop != null) {
			return shop;
		}
		else {
			return null;
		}
	}

	@Override
	public List<ShopInfo> displayAll() {
		return shopDao.findAll();
	}

	@Override
	public Optional<ShopInfo> getById(int id) {
		Optional<ShopInfo> shop = shopDao.findById(id);
		if(shop.isPresent()) {
			return Optional.ofNullable(shop.get());
		}
		else {
			return Optional.empty();
		}
	}

	@Override
	public ShopInfo addShop(ShopInfo shop) {
		try {
			return shopDao.save(shop);
		}catch (IllegalArgumentException e) {
			return null;
		}
	}

	@Override
	public ShopInfo updateShop(ShopInfo shop) {
		System.out.println("==============================");
		Optional<ShopInfo> shop1 = shopDao.findById(shop.getShopId());
		if(shop1.isPresent()) {
			ShopInfo shop2 = shop1.get();
			shop2.setShopName(shop.getShopName());
			shop2.setShopType(shop.getShopType());
			shop2.setShopAddress(shop.getShopAddress());
			shop2.setShopOwnerName(shop.getShopOwnerName());
			shop2.setPhone(shop.getPhone());
			shop2.setEmail(shop.getEmail());
			//shop2.setPassword(shop.getPassword());
			shop2.setIsActive(shop.getIsActive());
			shop2.setImage(shop.getImage());
//			shop2.setImage1(shop.getImage1());
			return shopDao.save(shop2);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		shopDao.deleteById(id);
	}

	@Override
	public ShopInfo updateShopPassword(int id, String oldPassword, String newPassword) {
		Optional<ShopInfo> shop = shopDao.findById(id);
		ShopInfo shop1 = shop.get();
		if(shop.isPresent()) {
			if(shop1.getPassword().equals(oldPassword)) {
				shop1.setPassword(newPassword);
				return shopDao.save(shop1);
			}
		}
		return null;
	}

	
}
