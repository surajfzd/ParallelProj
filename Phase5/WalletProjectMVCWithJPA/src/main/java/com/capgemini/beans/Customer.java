package com.capgemini.beans;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customertable")
public class Customer {
	
	@Column(name = "name")
	private String customerName;
	
	@Id
	@Column(name="mobileno")
	private String mobileNo;
	
	@Embedded
	@Column(name = "balance")
	private Wallet wallet;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String customerName, String mobileNo, Wallet wallet) {
		super();
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.wallet = wallet;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public Wallet getWallet() {
		return wallet;
	}


	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	
	
}
