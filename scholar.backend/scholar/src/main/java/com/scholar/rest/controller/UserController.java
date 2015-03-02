package com.scholar.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scholar.rest.model.User;
import com.scholar.rest.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;
	
	static final Logger logger = Logger.getLogger(UserController.class);

	/* Create a new recode */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addUser(@RequestBody User user) {
		if (user.getUserType().equalsIgnoreCase("donor")
				|| user.getUserType().equalsIgnoreCase("scholar")) {
			try {
				userService.addUser(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/* Read all the users */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> users = null;
		try {
			users = userService.getUsersList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	/* Read a user by userID */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable("id") int userId) {
		User user = null;
		try {
			user = userService.getUserById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/* Update a user information */
	@RequestMapping(value="/update", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@RequestBody User user){
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/* Delete a user by userID */
	@RequestMapping(value = "/delete/{userId}", method=RequestMethod.GET)
	public void deleteUser(@PathVariable("userId") int userId) {
		try {
			userService.deleteUser(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
