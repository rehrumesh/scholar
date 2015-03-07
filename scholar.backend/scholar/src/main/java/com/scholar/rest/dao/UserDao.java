package com.scholar.rest.dao;

import java.util.List;

import com.scholar.rest.model.User;

public interface UserDao {
	public void addUser(User user) throws Exception;

	public List<User> getUsersList() throws Exception;
	
	public User getUserById(int userId) throws Exception;
	
	public void updateUser(User user) throws Exception;

	public void deleteUser(int userId) throws Exception;
}
