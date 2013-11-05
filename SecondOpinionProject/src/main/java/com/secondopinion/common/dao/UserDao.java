package com.secondopinion.common.dao;

import com.secondopinion.common.model.User;

public interface UserDao {
	public void insert(User user);
	public User findByUserName(String userName);
	void addRoleForUser(User user);
}
