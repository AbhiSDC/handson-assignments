package com.hsbc.model.util;

import com.hsbc.model.dao.JdbcBackedUserDaoImpl;
import com.hsbc.model.business.UserServiceImpl;

public class UserFactory {

	public static Object getInstance(LayerType type) {
		Object obj = null;
		switch(type) {
			case SERVICE:
				obj = new UserServiceImpl();
				break;
			case DAO:
				obj = new JdbcBackedUserDaoImpl();
				break;
		}
		return obj;
	}
}
