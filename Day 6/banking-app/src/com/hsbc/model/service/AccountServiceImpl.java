package com.hsbc.model.service;

import com.hsbc.model.beans.Account;
import com.hsbc.exception.AccountNotFoundException;
import com.hsbc.exception.InsufficientBalanceException;
import com.hsbc.model.dao.AccountDao;
import com.hsbc.model.utility.AccountFactory;
import com.hsbc.model.utility.LayerType;

public class AccountServiceImpl implements AccountService {

	private AccountDao accDao;
	public AccountServiceImpl() {
		accDao = (AccountDao) AccountFactory.getInstance(LayerType.DAO);
	}

	@Override
	public Account createAccount(Account account) {
		Account acDao = accDao.store(account);
		return acDao;
	}

	@Override
	public Account[] fetchAccounts() {
		return accDao.fetchAccounts();
	}
	
	@Override
	public Account getAccountById(int accountNumber) throws AccountNotFoundException {
		Account accFromId = accDao.fetchAccountById(accountNumber);
		if(accFromId == null) {
			throw new AccountNotFoundException("This Account does not exist. Kindly check.");
		}
		return accFromId;
	}

	@Override
	public void transfer(int from, int to, double amount) throws InsufficientBalanceException {
		Account source = accDao.fetchAccountById(from);
		if(source.getBalance() < amount) {
			throw new InsufficientBalanceException("Balance of Source Account Number is too low!");
		}
		source.setBalance(source.getBalance() - amount);
		accDao.updateAccount(source.getAccountNumber(), source);
		
		Account target = accDao.fetchAccountById(to);
		target.setBalance(target.getBalance() + amount);
		accDao.updateAccount(target.getAccountNumber(), target);
	}

}
