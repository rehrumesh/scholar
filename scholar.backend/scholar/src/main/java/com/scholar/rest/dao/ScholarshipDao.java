package com.scholar.rest.dao;

import java.util.List;

import com.scholar.rest.model.Scholarship;

public interface ScholarshipDao {
	public void addScholarship(Scholarship scholarship) throws Exception;

	public List<Scholarship> getScholarshipByOwnerId(int ownerId) throws Exception;

	public void updateScholarship(Scholarship scholarship) throws Exception;

	public void deleteScholarship(int ScholarshipId) throws Exception;
}
