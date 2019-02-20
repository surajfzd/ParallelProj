package com.capgemini.repo;

import com.capgemini.beans.Customer;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InvalidMobileNumberException;

public interface WalletRepo 
{
	public boolean save(Customer customer);
	public Customer findOne(String mobileNo) throws InvalidMobileNumberException;

}
