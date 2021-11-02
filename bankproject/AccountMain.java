package com.bank.main;
import com.bank.account.Account;
import com.bank.exceptions.AccountCreateException;
import com.bank.exceptions.InsufficientBalanceException;
import com.bank.exceptions.WrongDepositException;

public class AccountMain {

	public static void main(String[] args) {

		Account act = null;

		try {
			act = new Account(111, "Kishore", 11500);
			System.out.println(act);
			act.withdraw(4000);
			System.out.println("Withdraw successful");
			act.deposit(90);
			System.out.println("deposit successful");
			System.out.println(act);

		} catch (InsufficientBalanceException ex) {
			System.out.println("Withdraw failed");
			System.out.println(ex.getMessage());
		} catch (AccountCreateException e) {
			System.out.println("Account creation failed ");
			System.out.println(e.getMessage());
		} catch (WrongDepositException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(act);

		System.out.println("Program completed");
	}

}
