package com.scholar.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.dao.TaskDao;
import com.scholar.rest.model.Task;

public class DonorServiceImpl implements DonorService {

	@Autowired
	TaskDao taskDao;
	
	public List<Task> getAllTasks(int userId) {
		return taskDao.getTasksByDonorId(userId);
	}

}
