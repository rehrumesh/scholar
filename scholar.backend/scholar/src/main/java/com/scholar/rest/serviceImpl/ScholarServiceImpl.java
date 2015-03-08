package com.scholar.rest.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.dao.RequestDao;
import com.scholar.rest.dao.TaskDao;
import com.scholar.rest.model.Request;
import com.scholar.rest.model.Task;
import com.scholar.rest.service.ScholarService;

public class ScholarServiceImpl implements ScholarService {

	@Autowired
	TaskDao taskDao;

	@Autowired
	RequestDao requestDao;

	public List<Task> getTasksListByScholarId(int scholarId) throws Exception {
		List<Task> tasksList = new ArrayList<Task>();
		List<Request> requestListForThisScholar = requestDao
				.getRequestList(scholarId);
		for (Request request : requestListForThisScholar) {
			int requestId = request.getRequestId();
			List<Task> tasksListByRequestId = taskDao
					.getTaskByRequestId(requestId);
			if (tasksListByRequestId != null) {
				tasksList.addAll(tasksListByRequestId);
			}
		}
		return tasksList;
	}
}
