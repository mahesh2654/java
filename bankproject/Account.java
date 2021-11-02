package com.bank.account;

import javax.management.InstanceAlreadyExistsException;

import com.bank.exceptions.AccountCreateException;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.exceptions.WrongDepositException;

public class Account {

	private int accountNumber;
	private String name;
	private float balance;

	public Account(int accountNumber, String name, float balance) throws AccountCreateException {
		super();

		if (balance < 1000)
			throw new AccountCreateException("cannot create account with balance less than 1000");

		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	public void withdraw(float amt) {
		// throw exception if balance not sufficient
		if (balance - 1000 < amt)
			throw new InsufficientBalanceException("Balance not sufficient to withdraw " + amt + "\nCurrent balance is " + balance);

		// adjust balance as per amt as there was no exception
		balance = balance - amt;

	}

	public void deposit(float amt) throws WrongDepositException {
		
		if(amt < 100)
			throw new WrongDepositException("deposit cannot be less than 100");
		balance = balance + amt;
	}

	@Override
	public String toString() {
		return "Account Number: " + accountNumber + "\nName: " + name + "\nBalance: " + balance;
	}

}
