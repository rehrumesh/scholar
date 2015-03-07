package com.scholar.rest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.model.Task;

public class TaskDaoImpl implements TaskDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction transaction = null;

	@SuppressWarnings("unchecked")
	public List<Task> getTasksByDonorId(int donorId) {
		List<Task> tasks = null;
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Task.class);
		criteria.add(Restrictions.eq("assignedBy", donorId));
		if (criteria.list().size() != 0) {
			tasks = criteria.list();
		}
		return tasks;
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTasksByScholarId(int scholarId) {
		List<Task> tasks = null;
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Task.class);
		criteria.add(Restrictions.eq("assignedTo", scholarId));
		if(criteria.list().size()!=0){
			tasks = criteria.list();
		}
		return tasks;
	}

}
