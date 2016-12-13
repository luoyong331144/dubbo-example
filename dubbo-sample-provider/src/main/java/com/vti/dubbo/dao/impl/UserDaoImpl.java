package com.vti.dubbo.dao.impl;

import org.springframework.stereotype.Component;

import com.vti.dubbo.dao.UserDao;

@Component
public class UserDaoImpl implements UserDao {

	@Override
	public int saveUser() {
		System.out.println("User Dao Impl save user");
		return 0;
	}

	@Override
	public int saveLog() {
		System.out.println("User Dao Impl save log");
		return 0;
	}
}
