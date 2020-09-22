package com.hsbc.controller;

import java.util.Scanner;

import com.hsbc.model.beans.Account;
import com.hsbc.exception.AccountNotFoundException;
import com.hsbc.exception.InsufficientBalanceException;
import com.hsbc.model.service.AccountService;
import com.hsbc.model.utility.AccountFactory;
import com.hsbc.model.utility.LayerType;

public class AccountMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		AccountService service = (AccountService) AccountFactory.getInstance(LayerType.SERVICE);
		int input = 0;
		do {
			System.out.println("---------------------------------------------------------------------------------------------");
			System.out.println("1: Store Account | 2:Fetch All Accounts | 3: Fetch Account By Id | 4:Transfer Amount | 5:Exit");
			System.out.println("---------------------------------------------------------------------------------------------");
			input = scanner.nextInt();
			switch(input) {
				case 1:
					Account acc = new Account();
					System.out.println("Enter the Customer Name: ");
					acc.setCustomerName(scanner.next());
					System.out.println("Enter the Balance: ");
					acc.setBalance(scanner.nextDouble());
					System.out.println("Enter the Contact Number: ");
					acc.setContactNumber(scanner.nextLong());
					Account customer = service.createAccount(acc);
					System.out.println("New Account Number added: " + customer.getAccountNumber());
					break;
				case 2:
					Account[] accounts = service.fetchAccounts();
					for(Account account:accounts) {
						if(account != null) {
							System.out.println(account);
						}
					}
					break;
				case 3:
					try {
						int accNo = scanner.nextInt();
						System.out.println(service.getAccountById(accNo));
					}
					catch(AccountNotFoundException e1) {
						System.err.println(e1.getMessage());
					}
					break;
				case 4:
					try {
						System.out.println("Enter the Source Account: ");
						int from = scanner.nextInt();
						System.out.println("Enter the Target Account: ");
						int to = scanner.nextInt();
						System.out.println("Enter the Amount: ");
						double amount = scanner.nextDouble();
						service.transfer(from, to, amount);
						System.out.println("Amount Transferred Successfully!!");
					}
					catch(InsufficientBalanceException e2){
						System.err.println(e2.getMessage());
					}
					break;
			}
		} while(input != 5);
		
		scanner.close();

	}

}
