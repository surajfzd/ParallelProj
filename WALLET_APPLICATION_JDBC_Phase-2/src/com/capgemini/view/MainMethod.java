package com.capgemini.view;

import java.math.BigDecimal;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InsufficientWalletBalanceException;
import com.capgemini.exception.InvalidMobileNumberException;
import com.capgemini.repo.WalletRepo;
import com.capgemini.repo.WalletRepoImpl;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImpl;

public class MainMethod 
{

	public static void main(String[] args) throws Exception
	{

		WalletService walletservice=new WalletServiceImpl(new WalletRepoImpl());
		Customer customer=new Customer();
		
		try
		{
			customer=walletservice.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("50000")));
			System.out.println(customer);
//			System.out.println(walletservice.createAccount("Vansh", "9999999999", new Wallet(new BigDecimal("20000"))));
//			System.out.println(walletservice.createAccount("Sushil", "9999999999", new Wallet(new BigDecimal("30000"))));
//			System.out.println(walletservice.showBalance("9897934489"));
//			System.out.println(walletservice.depositAmount("9897934489", new BigDecimal("12345")));
//			System.out.println(walletservice.withdrawAmount("9897934489", new BigDecimal("20000")));
//			System.out.println(walletservice.fundTransfer("9897934489", "9999999999", new BigDecimal("20000")));
		}
		
		catch(DuplicateMobileNumberException e)
		{
			System.out.println("DuplicateMobileNumberException");
		}
//		catch(InsufficientWalletBalanceException ee)
//		{
//			System.out.println("InsufficientWalletBalanceException");
//		}
//		catch(InvalidMobileNumberException eee)
//		{
//			System.out.println("InvalidMobileNumberException");
//		
//		}
		
	}
		
}
		