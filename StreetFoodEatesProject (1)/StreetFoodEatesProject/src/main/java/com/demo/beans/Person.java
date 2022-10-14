package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
public class Person {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	
	private String pname;
	private String pemail;
	private String password;
	private String address;
	private int PhoneNo;
	
	
		public Person() {
			super();
		}
		public Person(int pid, String pname, String pemail, String password, String address, int phoneNo) {
			super();
			this.pid = pid;
			this.pname = pname;
			this.pemail = pemail;
			this.password = password;
			this.address = address;
			PhoneNo = phoneNo;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public String getPname() {
			return pname;
		}
		public void setPname(String pname) {
			this.pname = pname;
		}
		public String getPemail() {
			return pemail;
		}
		public void setPemail(String pemail) {
			this.pemail = pemail;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public int getPhoneNo() {
			return PhoneNo;
		}
		public void setPhoneNo(int phoneNo) {
			PhoneNo = phoneNo;
		}
		@Override
		public String toString() {
			return "Person [pid=" + pid + ", pname=" + pname + ", pemail=" + pemail + ", password=" + password
					+ ", address=" + address + ", PhoneNo=" + PhoneNo + "]";
		}
	
	

}
