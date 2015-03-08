package com.scholar.rest.service;

import java.util.List;

import com.scholar.rest.model.Task;

public interface DonorService {
	public List<Task> getAllTasksByDonorId(int donorId) throws Exception;
}
