package com.capgemini.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.capgemini.beans.Customer;
import com.capgemini.beans.Wallet;
import com.capgemini.exception.DuplicateMobileNumberException;
import com.capgemini.exception.InvalidMobileNumberException;

public class WalletRepoImpl implements WalletRepo {
	Customer customer;

	@Override
	public boolean save(Customer customer) {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
					"Capgemini123");
			PreparedStatement stmt = con.prepareStatement("insert into customers(mobileno, name, balance) values(?,?,?)");
			stmt.setString(1, customer.getMobileno());
			stmt.setString(2, customer.getName());
			stmt.setInt(3, customer.getWallet().getBalance().intValue());
			stmt.executeUpdate();
			con.close();
			return true;
		} catch (Exception e) {
			System.out.println("error occur in sql connectivity");
		}

		return false;
	}

	@Override
	public Customer findOne(String mobileNo) throws InvalidMobileNumberException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system","Capgemini123");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from customers");
			System.out.println("_______________________________________________________________________");
			while (rs.next()) {
				// System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3));
				if (rs.getString(1).equals(mobileNo)) {
					BigDecimal balance = new BigDecimal(rs.getInt(3));
					Wallet wallet = new Wallet(balance);
					return new Customer(rs.getString(2), rs.getString(1), wallet);
				}
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
