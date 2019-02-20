package com.capgemini.beans;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="CustomerTable")
public class Customer 
{
	@Column(name = "name")
	private String name;
	@Id
	@Column(name = "mobile")
	private String mobileno;
	@Embedded
	private Wallet wallet;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String mobileno, Wallet wallet) {
		super();
		this.name = name;
		this.mobileno = mobileno;
		this.wallet = wallet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	@Override
	public String toString()
	{
		return "Customer[name: "+name+" MobileNumber: "+mobileno+" Wallet: "+wallet+"]";
	}
	
	

}
