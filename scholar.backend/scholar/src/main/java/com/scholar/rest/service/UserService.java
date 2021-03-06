package com.scholar.rest.service;

import java.util.List;

import com.scholar.rest.model.User;

public interface UserService {
	public void addUser(User user) throws Exception;

	public List<User> getUsersList() throws Exception;

	public User getUserByUserId(int userId) throws Exception;
	
	public void updateUser(User user) throws Exception;

	public void deleteUser(int userId) throws Exception;
}
