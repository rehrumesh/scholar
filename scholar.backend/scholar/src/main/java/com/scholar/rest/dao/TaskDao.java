package com.scholar.rest.dao;

import java.util.List;

import com.scholar.rest.model.Task;

public interface TaskDao {
	public void addTask(Task task);

	public List<Task> getTaskByScholarshipId(int scholarshipId);

	public List<Task> getTaskByRequestId(int requestId);
}
