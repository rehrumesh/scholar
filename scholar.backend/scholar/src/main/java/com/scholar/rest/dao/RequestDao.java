package com.scholar.rest.dao;

import java.util.List;

import com.scholar.rest.model.Request;

public interface RequestDao {
	public void addRequest(Request reaquest) throws Exception;

	public List<Request> getRequestList() throws Exception;
	
	public List<Request> getRequestList(int requesterId) throws Exception;

	public void updateRequest(Request request) throws Exception;

	public void deleteRequest(int requestId) throws Exception;
}
