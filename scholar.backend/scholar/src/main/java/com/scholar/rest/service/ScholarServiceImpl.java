package com.scholar.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.dao.TaskDao;
import com.scholar.rest.model.Task;

public class ScholarServiceImpl implements ScholarService {

	@Autowired
	TaskDao taskDao;
	
	public List<Task> getTasksByScholarId(int scholarId) {
		return taskDao.getTasksByScholarId(scholarId);
	}

}
