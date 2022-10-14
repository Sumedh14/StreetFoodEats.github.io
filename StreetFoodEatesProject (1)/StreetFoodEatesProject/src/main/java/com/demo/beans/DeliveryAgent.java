package com.demo.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import  com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="delivery_agent")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "deliveryAgentId")
public class DeliveryAgent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  deliveryAgentId;
	
	private String deliveryAgentName;
	
	private String deliveryAgentEmail;
	
	private String deliveryAgentPassword;
	
	private String deliveryAgentAddress;
	
	private String deliveryAgentPhoneNo;
	
	@OneToMany(mappedBy="deliveryAgent",cascade=CascadeType.ALL)
//	@JsonManagedReference
	private List<Order> order;
	
	public DeliveryAgent() {
		super();
	}
	

public DeliveryAgent(int deliveryAgentId, String deliveryAgentName, String deliveryAgentEmail,
			String deliveryAgentPassword, String deliveryAgentAddress, String deliveryAgentPhoneNo, List<Order> order) {
		super();
		this.deliveryAgentId = deliveryAgentId;
		this.deliveryAgentName = deliveryAgentName;
		this.deliveryAgentEmail = deliveryAgentEmail;
		this.deliveryAgentPassword = deliveryAgentPassword;
		this.deliveryAgentAddress = deliveryAgentAddress;
		this.deliveryAgentPhoneNo = deliveryAgentPhoneNo;
		this.order = order;
	}


//	public DeliveryAgent(int deliveryAgentId, String deliveryAgentName, String deliveryAgentEmail,
//			String deliveryAgentPassword, String deliveryAgentAddress, String deliveryAgentPhoneNo) {
//		super();
//		this.deliveryAgentId = deliveryAgentId;
//		this.deliveryAgentName = deliveryAgentName;
//		this.deliveryAgentEmail = deliveryAgentEmail;
//		this.deliveryAgentPassword = deliveryAgentPassword;
//		this.deliveryAgentAddress = deliveryAgentAddress;
//		this.deliveryAgentPhoneNo = deliveryAgentPhoneNo;
//	}


	public int getDeliveryAgentId() {
		return deliveryAgentId;
	}


	public void setDeliveryAgentId(int deliveryAgentId) {
		this.deliveryAgentId = deliveryAgentId;
	}


	public String getDeliveryAgentName() {
		return deliveryAgentName;
	}


	public void setDeliveryAgentName(String deliveryAgentName) {
		this.deliveryAgentName = deliveryAgentName;
	}


	public String getDeliveryAgentEmail() {
		return deliveryAgentEmail;
	}


	public void setDeliveryAgentEmail(String deliveryAgentEmail) {
		this.deliveryAgentEmail = deliveryAgentEmail;
	}


	public String getDeliveryAgentPassword() {
		return deliveryAgentPassword;
	}


	public void setDeliveryAgentPassword(String deliveryAgentPassword) {
		this.deliveryAgentPassword = deliveryAgentPassword;
	}


	public String getDeliveryAgentAddress() {
		return deliveryAgentAddress;
	}


	public void setDeliveryAgentAddress(String deliveryAgentAddress) {
		this.deliveryAgentAddress = deliveryAgentAddress;
	}


	public String getDeliveryAgentPhoneNo() {
		return deliveryAgentPhoneNo;
	}


	public void setDeliveryAgentPhoneNo(String deliveryAgentPhoneNo) {
		this.deliveryAgentPhoneNo = deliveryAgentPhoneNo;
	}

	
	
	public List<Order> getOrder() {
		return order;
	}


	public void setOrder(List<Order> order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "DeliveryAgent [deliveryAgentName=" + deliveryAgentName + ", deliveryAgentEmail=" + deliveryAgentEmail
				+ ", deliveryAgentAddress=" + deliveryAgentAddress + ", deliveryAgentPhoneNo=" + deliveryAgentPhoneNo
				+ "]";
	}


	
	
	
	
	
}




/*
 * package com.demo.beans;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.Table;
 * 
 * @Entity
 * 
 * @Table(name="delivery_agent") public class DeliveryAgent {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy=GenerationType.IDENTITY) private int
 * deliveryAgentId;
 * 
 * private String deliveryAgentName;
 * 
 * private String deliveryAgentEmail;
 * 
 * private String deliveryAgentPassword;
 * 
 * private String deliveryAgentAddress;
 * 
 * private String deliveryAgentPhoneNo;
 * 
 * public DeliveryAgent() { super(); }
 * 
 * 
 * public DeliveryAgent(int deliveryAgentId, String deliveryAgentName, String
 * deliveryAgentEmail, String deliveryAgentPassword, String
 * deliveryAgentAddress, String deliveryAgentPhoneNo) { super();
 * this.deliveryAgentId = deliveryAgentId; this.deliveryAgentName =
 * deliveryAgentName; this.deliveryAgentEmail = deliveryAgentEmail;
 * this.deliveryAgentPassword = deliveryAgentPassword; this.deliveryAgentAddress
 * = deliveryAgentAddress; this.deliveryAgentPhoneNo = deliveryAgentPhoneNo; }
 * 
 * 
 * public int getDeliveryAgentId() { return deliveryAgentId; }
 * 
 * 
 * public void setDeliveryAgentId(int deliveryAgentId) { this.deliveryAgentId =
 * deliveryAgentId; }
 * 
 * 
 * public String getDeliveryAgentName() { return deliveryAgentName; }
 * 
 * 
 * public void setDeliveryAgentName(String deliveryAgentName) {
 * this.deliveryAgentName = deliveryAgentName; }
 * 
 * 
 * public String getDeliveryAgentEmail() { return deliveryAgentEmail; }
 * 
 * 
 * public void setDeliveryAgentEmail(String deliveryAgentEmail) {
 * this.deliveryAgentEmail = deliveryAgentEmail; }
 * 
 * 
 * public String getDeliveryAgentPassword() { return deliveryAgentPassword; }
 * 
 * 
 * public void setDeliveryAgentPassword(String deliveryAgentPassword) {
 * this.deliveryAgentPassword = deliveryAgentPassword; }
 * 
 * 
 * public String getDeliveryAgentAddress() { return deliveryAgentAddress; }
 * 
 * 
 * public void setDeliveryAgentAddress(String deliveryAgentAddress) {
 * this.deliveryAgentAddress = deliveryAgentAddress; }
 * 
 * 
 * public String getDeliveryAgentPhoneNo() { return deliveryAgentPhoneNo; }
 * 
 * 
 * public void setDeliveryAgentPhoneNo(String deliveryAgentPhoneNo) {
 * this.deliveryAgentPhoneNo = deliveryAgentPhoneNo; }
 * 
 * 
 * @Override public String toString() { return "DeliveryAgent [deliveryAgentId="
 * + deliveryAgentId + ", deliveryAgentName=" + deliveryAgentName +
 * ", deliveryAgentEmail=" + deliveryAgentEmail + ", deliveryAgentPassword=" +
 * deliveryAgentPassword + ", deliveryAgentAddress=" + deliveryAgentAddress +
 * ", deliveryAgentPhoneNo=" + deliveryAgentPhoneNo + "]"; }
 * 
 * 
 * 
 * 
 * }
 */