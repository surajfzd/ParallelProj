package com.capgemini.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.beans.Wallet;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InsufficientWalletBalanceException;
import com.capgemini.exception.InvalidMobileNumberException;
import com.capgemini.repo.WalletRepoImpl;
import com.capgemini.service.WalletService;
import com.capgemini.service.WalletServiceImpl;

public class Testing 
{
	WalletService service=new WalletServiceImpl(new WalletRepoImpl());
	
	
	//-------------------------------CREATE ACCOUNT----------------------------------------------------------------------------
	
	//When Duplicate Mobile Number Is Passed ThrowException
	
//	@Test(expected=com.capgemini.exception.DuplicateMobileNumberException.class)
//	public void WhenDuplicateMobileNumberIsPassedThrowException() throws DuplicateMobileNumberException
//	{
//		//Wallet wallet=new Wallet();
//		service.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("20000.00")));
//		service.createAccount("vbcbs", "9897934489", new Wallet(new BigDecimal("20000.00")));
//	}
	
	//When Valid Mobile Number Is Passed account creates successfully
	
	@Test
	public void WhenDuplicateMobileNumberIsPassedNotThrowException() throws DuplicateMobileNumberException
	{
		service.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("20000.00")));
	}
	
	
//	//-------------------------------SHOW BALANCE-------------------------------------------------------------------------------
//	
//	//When Invalid Mobile Number Is Passed To ShowBalance ThrowException
//	@Test(expected=com.capgemini.exception.InvalidMobileNumberException.class)
//	public void WhenInvalidMobileNumberIsPassedToShowBalanceThrowException() throws InvalidMobileNumberException,InsufficientWalletBalanceException,DuplicateMobileNumberException
//	{
//		service.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("20000.00")));
//	}
//	
//	
//	//When Invalid Mobile Number Is Passed, Show Balance Successfully
//	@Test
//	public void WhenValidMobileNumberIsPassedShowBalanceSuccessfully() throws InvalidMobileNumberException,InsufficientWalletBalanceException,DuplicateMobileNumberException
//	{
//		service.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("20000.00")));
//		service.showBalance("9897934489");
//	}
//	
//	
//	
//	
//	//-------------------------------WITHDRAW AMOUNT------------------------------------------------------------------------------
//	
//	//When Invalid Mobile Number Is Passed To Withdraw Amount ThrowException
//	
////	@Test(expected=com.capgemini.exception.InvalidMobileNumberException.class)
////	public void WhenInvalidMobileNumberIsPassedToWithdrawAmountThrowException() throws InvalidMobileNumberException,InsufficientWalletBalanceException,DuplicateMobileNumberException
////	{
////		Wallet wallet=new Wallet();
////		service.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("20000.00")));
////		service.withdrawAmount("9999999999", new BigDecimal("10000.00"));
////	}
//	
//	
//	//When Valid Mobile Number Is Passed, Show Balance Successfully
//	
//	
//	
//	//-------------------------------DEPOSIT AMOUNT-----------------------------------------------------------------------------
//	
//	//When Invalid Mobile Number Is Passed To Deposit Amount ThrowException
//	
//	@Test(expected=com.capgemini.exception.InvalidMobileNumberException.class)
//	public void WhenInvalidMobileNumberIsPassedToDepositAmountThrowException() throws InvalidMobileNumberException,InsufficientWalletBalanceException,DuplicateMobileNumberException
//	{
//		service.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("20000.00")));
//		service.depositAmount("9999999999", new BigDecimal("2000.0"));
//	}
//	
//	//When Valid Mobile Number Is Passed, Deposit Amount Successfully
//	
//	@Test
//	public void WhenValidMobileNumberIsPassedDepositAmountSuccessfully() throws InvalidMobileNumberException,InsufficientWalletBalanceException,DuplicateMobileNumberException
//	{
//		service.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("20000.00")));
//		service.depositAmount("9897934489", new BigDecimal("5000.0"));
//	}
//	
//	
//	//-------------------------------FUND TRANSFER-----------------------------------------------------------------------------
//	
//	//When Invalid Mobile Number Is Passed ThrowException
//	@Test(expected=com.capgemini.exception.InvalidMobileNumberException.class)
//	public void WhenInvalidMobileNumberIsPassedToFundTransferThrowException() throws InvalidMobileNumberException,InsufficientWalletBalanceException,DuplicateMobileNumberException
//	{
//		service.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("100.00")));
//		service.createAccount("Vansh", "8888888888", new Wallet(new BigDecimal("50.00")));
//	}
//	
//	//When Valid Mobile Number Is Passed, Fund Transfer Successfully
//		@Test
//		public void WhenValidMobileNumberIsPassedFundTransferSuccessfully() throws InvalidMobileNumberException,InsufficientWalletBalanceException,DuplicateMobileNumberException
//		{
//			service.createAccount("Suraj", "9897934489", new Wallet(new BigDecimal("100.00")));
//			service.createAccount("Vansh", "8888888888", new Wallet(new BigDecimal("50.00")));
//			service.fundTransfer("9897934489", "8888888888", (new BigDecimal("50.00")));
//		}
//	

}
