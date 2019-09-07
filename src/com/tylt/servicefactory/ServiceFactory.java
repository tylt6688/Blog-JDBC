package com.tylt.servicefactory;

import com.tylt.service.UserService;
import com.tylt.serviceImpl.UserServiceImpl;

public class ServiceFactory {

	private static UserService us = null;

	public synchronized static UserService geUser() {
		if (us == null) {
			us = new UserServiceImpl();
		}
		return us;
	}

}
