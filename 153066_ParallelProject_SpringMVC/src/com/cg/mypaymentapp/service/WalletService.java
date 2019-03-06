package com.cg.mypaymentapp.service;
import java.math.BigDecimal;
import java.util.List;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;

public interface WalletService {
public Customer createAccount(Customer customer);
public Customer showBalance (String mobileno);
public Customer fundTransfer (String sourceMobileNo,String targetMobileNo, BigDecimal amount) throws InvalidInputException, InsufficientBalanceException;
public Customer depositAmount (String mobileNo,BigDecimal amount )throws InvalidInputException;
public Customer withdrawAmount(String mobileNo, BigDecimal amount)throws InvalidInputException, InsufficientBalanceException;

public List getTransaction(String mob);
}
