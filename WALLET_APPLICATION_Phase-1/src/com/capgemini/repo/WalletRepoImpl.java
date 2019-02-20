package com.capgemini.repo;

//import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.capgemini.beans.Customer;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InvalidMobileNumberException;

public class WalletRepoImpl implements WalletRepo {
	Customer customer;
	Map<String, Customer> hashmap = new HashMap<>();

	@Override
	public boolean save(Customer customer) {
		if (hashmap.containsKey(customer.getMobileno())) {
			return false;
		}
		else
		{
		hashmap.put(customer.getMobileno(), customer);
		return true;
		}
	}

	@Override
	public Customer findOne(String mobileNo) throws InvalidMobileNumberException {
		for (Entry<String, Customer> entry : hashmap.entrySet()) {
			if (entry.getKey().equals(mobileNo))
				return entry.getValue();
		}
		throw new InvalidMobileNumberException();
	}

}
