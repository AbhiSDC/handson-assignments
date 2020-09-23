package com.hsbc.model.utility;

import com.hsbc.model.business.UserServiceImpl;
//import com.hsbc.model.dao.ArrayBackedUserDao;
import com.hsbc.model.dao.CollectionBackedUserDao;


public class UserFactory {
	// it can return dao, service or controller instance
	
	
	public static Object getInstance(Type type) {
		Object obj = null;
		switch(type) {
		case DAO : 
			//obj = new ArrayBackedUserDao();
			obj = new CollectionBackedUserDao();
			break;
		case SERVICE :
			obj = new UserServiceImpl();
			break;
		}
		return obj;
	}
}
