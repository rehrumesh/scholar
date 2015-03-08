package com.scholar.rest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.dao.UserDao;
import com.scholar.rest.model.User;
import com.scholar.rest.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	public void addUser(User user) throws Exception {
		userDao.addUser(user);
	}

	public List<User> getUsersList() throws Exception {
		return userDao.getUsersList();
	}

	public User getUserByUserId(int userId) throws Exception {
		return userDao.getUserById(userId);
	}

	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	public void deleteUser(int userId) throws Exception {
		userDao.deleteUser(userId);
	}
}
