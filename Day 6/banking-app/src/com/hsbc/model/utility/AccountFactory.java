package com.hsbc.model.utility;

import com.hsbc.model.dao.AccountDaoImpl;
import com.hsbc.model.service.AccountServiceImpl;

public class AccountFactory {
	
	public static Object getInstance(LayerType type) {
		Object obj = null;
		
		switch(type) {
		case DAO:
			obj = new AccountDaoImpl();
			break;
		case SERVICE:
			obj = new AccountServiceImpl();
			break;
		}
		return obj;
	}
}
