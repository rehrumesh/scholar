package com.scholar.rest.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.dao.ScholarshipDao;
import com.scholar.rest.dao.TaskDao;
import com.scholar.rest.model.Scholarship;
import com.scholar.rest.model.Task;
import com.scholar.rest.service.DonorService;

public class DonorServiceImpl implements DonorService {

	@Autowired
	TaskDao taskDao;

	@Autowired
	ScholarshipDao scholarshipDao;

	public List<Task> getAllTasksByDonorId(int donorId) throws Exception {
		List<Task> tasksListByDonorId = new ArrayList<Task>();
		List<Scholarship> scholarshipByThisDonor = scholarshipDao
				.getScholarshipByOwnerId(donorId);
		for (Scholarship scholarship : scholarshipByThisDonor) {
			int scholarshipId = scholarship.getScholarshipId();
			List<Task> taskForThisScholarship = taskDao
					.getTaskByScholarshipId(scholarshipId);
			if (taskForThisScholarship != null) {
				tasksListByDonorId.addAll(taskForThisScholarship);
			}
		}
		return tasksListByDonorId;
	}

}
