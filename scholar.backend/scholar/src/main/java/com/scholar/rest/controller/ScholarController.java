package com.scholar.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scholar.rest.model.Task;
import com.scholar.rest.service.ScholarService;

@RestController
@RequestMapping(value="/scholar")
public class ScholarController {
	
	@Autowired
	ScholarService scholarService;
	
	@RequestMapping(value="/taskslist/{scholarId}", method=RequestMethod.GET)
	public List<Task> getTaskBySchoarId(@PathVariable("scholarId") int scholarId){
		List<Task> tasks = null;
		try {
			tasks = scholarService.getTasksByScholarId(scholarId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tasks;
	}
}
