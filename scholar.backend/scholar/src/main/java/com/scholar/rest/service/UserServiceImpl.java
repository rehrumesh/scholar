package com.scholar.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.dao.UserDao;
import com.scholar.rest.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void addUser(User user) throws Exception {
		userDao.addUser(user);
	}

	public List<User> getUsersList() throws Exception {
		return userDao.getUsersList();
	}

	public User getUserById(int userId) throws Exception {
		return userDao.getUserById(userId);
	}

	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	public void deleteUser(int userId) throws Exception {
		userDao.deleteUser(userId);
	}
}
