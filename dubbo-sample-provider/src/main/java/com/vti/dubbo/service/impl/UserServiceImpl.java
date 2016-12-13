package com.vti.dubbo.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.vti.dubbo.dao.UserDao;
import com.vti.dubbo.service.UserService;

public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	@Transactional
	public String reg(String msg) {
		userDao.saveLog();
		userDao.saveUser();
		String result = "i am from UserServiceImpl Reg " + msg;
		return result;
	}

}
