package com.demo.beans;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="shop_info_table")
public class ShopInfo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shopId;
	
	private String shopName;
	
	private String shopType;
	
	private String shopAddress;
	
	private String shopOwnerName;
	
	private String phone;
	
	private String email;
	
	private String password;
	
	private String isActive;
	
	 private String image;
	 
	
	@Lob 
	private byte[] imageReal;
	
	public ShopInfo() {
		super();
	}

	
	
	public ShopInfo(String shopName, String shopType, String shopAddress, String shopOwnerName, String phone,
			String email, String password, String isActive, String image) {
		super();
		this.shopName = shopName;
		this.shopType = shopType;
		this.shopAddress = shopAddress;
		this.shopOwnerName = shopOwnerName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.image = image;
	}

//	public ShopInfo(int shopId, String shopName, String shopType, String shopAddress, String shopOwnerName,
//			String phone, String email, String password, String isActive, byte[] imageReal) {
//		super();
//		this.shopId = shopId;
//		this.shopName = shopName;
//		this.shopType = shopType;
//		this.shopAddress = shopAddress;
//		this.shopOwnerName = shopOwnerName;
//		this.phone = phone;
//		this.email = email;
//		this.password = password;
//		this.isActive = isActive;
//		this.imageReal = imageReal;
//	}



	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopType() {
		return shopType;
	}

	public void setShopType(String shopType) {
		this.shopType = shopType;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopOwnerName() {
		return shopOwnerName;
	}

	public void setShopOwnerName(String shopOwnerName) {
		this.shopOwnerName = shopOwnerName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	  public String getImage() { return image; }
	 
	 public void setImage(String image) { this.image = image; }
	 
    
	
//	public byte[] getImage1() {
//		return imageReal;
//	}
//
//	public void setImage1(byte[] imageReal) {
//		this.imageReal = imageReal;
//	}



//	@Override
//	public String toString() {
//		return "ShopInfo [shopId=" + shopId + ", shopName=" + shopName + ", shopType=" + shopType + ", shopAddress="
//				+ shopAddress + ", shopOwnerName=" + shopOwnerName + ", phone=" + phone + ", email=" + email
//				+ ", password=" + password + ", isActive=" + isActive + ", imageReal=" + Arrays.toString(imageReal)
//				+ "]";
//	}
	
	
	@Override
	public String toString() {
		return "ShopInfo [shopId=" + shopId + ", shopName=" + shopName + ", shopType=" + shopType + ", shopAddress="
				+ shopAddress + ", shopOwnerName=" + shopOwnerName + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", isActive=" + isActive + ", image=" + image + "]";
	}
}
