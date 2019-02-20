package com.capgemini.repo;

import java.math.BigDecimal;
//import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InvalidMobileNumberException;
import com.capgemini.util.ConnectionUtil;

public class WalletRepoImpl implements WalletRepo {

	// ConnectionUtil cu=new ConnectionUtil();

	@Override
	public boolean save(Customer customer) {
		try {
			EntityManager entitymanager = ConnectionUtil.getConnection();
			entitymanager.getTransaction().begin();
			Customer custom = new Customer();
			Wallet wallet = new Wallet();
			custom.setName(customer.getName());
			custom.setMobileno(customer.getMobileno());
			wallet.setBalance(customer.getWallet().getBalance());
			custom.setWallet(wallet);
			entitymanager.persist(custom);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}

		return true;

	}

	@Override
	public Customer findOne(String mobileNo) throws InvalidMobileNumberException {
		try {
			EntityManager entitymanager = ConnectionUtil.getConnection();
			entitymanager.getTransaction().begin();
			Customer custom = new Customer();
			custom = entitymanager.find(Customer.class, mobileNo);
			entitymanager.getTransaction().commit();
			return custom;
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}

	@Override
	public void update(String mobileno, BigDecimal amount) 
	{
		try
		{
			EntityManager entitymanager = ConnectionUtil.getConnection();
			entitymanager.getTransaction().begin();
			Customer custom = new Customer();
			Wallet wallet = new Wallet();
			custom=entitymanager.find(Customer.class,mobileno );
			wallet.setBalance(amount);
			custom.setWallet(wallet);
			entitymanager.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
