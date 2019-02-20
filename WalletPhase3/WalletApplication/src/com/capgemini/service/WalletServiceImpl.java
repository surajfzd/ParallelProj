package com.capgemini.service;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InsufficientWalletBalanceException;
import com.capgemini.exception.InvalidMobileNumberException;
import com.capgemini.repo.WalletRepo;
import com.capgemini.repo.WalletRepoImpl;

public class WalletServiceImpl implements WalletService {

	private WalletRepoImpl repo;

	public WalletServiceImpl(WalletRepoImpl repo) {
		super();
		this.repo = repo;
	}

	// CREATE ACCOUNT
	@Override
	public Customer createAccount(String name, String mobileno, Wallet wallet) throws DuplicateMobileNumberException {
		Customer customer = new Customer(name, mobileno, wallet);
		if (repo.save(customer)) {
			return customer;
		} else
			throw new DuplicateMobileNumberException();
	}

	// SHOW BALANCE
	@Override
	public BigDecimal showBalance(String mobileno) throws InvalidMobileNumberException {

		return repo.findOne(mobileno).getWallet().getBalance();
	}

	// DEPOSIT AMOUNT
	@Override
	public Customer depositAmount(String mobileNo, BigDecimal amount) throws InvalidMobileNumberException {
		Customer customer = repo.findOne(mobileNo);
		Wallet wallet = customer.getWallet();
		wallet.setBalance(wallet.getBalance().add(amount));
		customer.setWallet(wallet);
		return customer;
	}

	// WITHDRAW AMOUNT
	@Override
	public Customer withdrawAmount(String mobileNo, BigDecimal amount)
			throws InvalidMobileNumberException, InsufficientWalletBalanceException {
		Customer customer = repo.findOne(mobileNo);
		Wallet wallet = customer.getWallet();
		if (wallet.getBalance().compareTo(amount) == -1) {
			throw new InsufficientWalletBalanceException();
		}
		wallet.setBalance(wallet.getBalance().subtract(amount));
		customer.setWallet(wallet);
		return customer;
	}

	// FUND TRANSFER
	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, BigDecimal amount)
			throws InvalidMobileNumberException, InsufficientWalletBalanceException {

		Customer customer = repo.findOne(sourceMobileNo);
		withdrawAmount(sourceMobileNo, amount);
		depositAmount(targetMobileNo, amount);

		return customer;
	}

}
