package com.scholar.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scholar.rest.model.Task;
import com.scholar.rest.service.DonorService;

@RestController
@RequestMapping(value = "/donor")
public class DonorController {

	@Autowired
	DonorService donorService;

	@RequestMapping(value = "/taskslist/{userId}", method = RequestMethod.GET)
	public List<Task> getAllTasks(@PathVariable("userId") int userId) {
		List<Task> tasks = null;
		try {
			tasks = donorService.getAllTasks(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}
}
