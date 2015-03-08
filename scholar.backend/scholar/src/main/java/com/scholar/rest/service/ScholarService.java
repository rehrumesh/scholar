package com.scholar.rest.service;

import java.util.List;

import com.scholar.rest.model.Task;

public interface ScholarService {
	public List<Task> getTasksListByScholarId(int scholarId) throws Exception;
}
