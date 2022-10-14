package com.demo.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name ="dish")
public class Dish {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dishId;
	
	private String dishName;
	
	private String description;
	
	private double price;
	
	private /* byte[] */  String  dishImage;
	
	/*@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
            name = "dish_shop_table",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "shop_id")
            )	*/
	@ManyToOne
	@JoinColumn(name = "shop_id")
	private ShopInfo shop;  ;
	
	/*@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
            name = "category_dish_table",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_category_id")
            )	*/
//	@ManyToOne(cascade = {CascadeType.ALL})
//	@JoinColumn(name = "dish_category_id")
//	private DishCategory dishCategory;
//	
	private String dishCategory;
	
	public Dish() {
		super();
	}

	public Dish(String dishName, String description, double price, String image, ShopInfo shop,
			String dishCategory) {
		super();
		this.dishName = dishName;
		this.description = description;
		this.price = price;
		this.dishImage = image;
		this.shop = shop;
		this.dishCategory = dishCategory;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDishImage() {
		return dishImage;
	}

	public void setDishImage(String image) {
		this.dishImage = image;
	}

	public ShopInfo getShop() {
		return shop;
	}

	public void setShop(ShopInfo shop) {
		this.shop = shop;
	}

	public String getDishCategory() {
		return dishCategory;
	}

	public void setDishCategory(String dishCategory) {
		this.dishCategory = dishCategory;
	}

	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", description=" + description + ", price=" + price
				+ ", image=" + dishImage + ", shop=" + shop + ", dishCategory=" + dishCategory + "]";
	}
}
