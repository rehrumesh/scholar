package com.scholar.rest.dao;

import java.util.List;

import com.scholar.rest.model.Task;

public interface TaskDao {
	public List<Task> getTasksByDonorId(int donorId);

	public List<Task> getTasksByScholarId(int scholarId);
}
