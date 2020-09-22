package com.hsbc.model.dao;

import com.hsbc.model.beans.Account;

public class AccountDaoImpl implements AccountDao {
	
	Account[] accounts = new Account[20];
	private static int index = 0;
	@Override
	public Account store(Account account) {
		accounts[index++] = account;
		return account;
	}

	@Override
	public Account[] fetchAccounts() {
		return accounts;
	}

	@Override
	public Account fetchAccountById(int accountNumber) {
		for(int i=0; i < index; i++) {
			if(accounts[i].getAccountNumber() == accountNumber) {
				return accounts[i];
			}
		}
		return null;
	}

	@Override
	public Account updateAccount(int accountNumber, Account account) {
		for(int i=0; i < index; i++) {
			if(accounts[i].getAccountNumber() == accountNumber) {
				accounts[i].setBalance(account.getBalance());
				break;
			}
		}
		return account;
	}

}
