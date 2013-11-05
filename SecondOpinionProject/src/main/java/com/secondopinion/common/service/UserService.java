package com.secondopinion.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.secondopinion.common.dao.UserDao;
import com.secondopinion.common.model.User;

@Component
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User createUser(User user) {
		userDao.insert(user);
		user = userDao.findByUserName(user.getUserName());
		userDao.addRoleForUser(user);
		return user;
	}
	
	public User findUserByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

}
