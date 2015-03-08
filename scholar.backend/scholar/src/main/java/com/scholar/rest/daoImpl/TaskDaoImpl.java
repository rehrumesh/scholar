package com.scholar.rest.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.dao.TaskDao;
import com.scholar.rest.model.Task;

public class TaskDaoImpl implements TaskDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction transaction = null;

	public void addTask(Task task) {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(task);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTaskByScholarshipId(int scholarshipId) {
		List<Task> tasks = null;
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Task.class);
		criteria.add(Restrictions.eq("scholarshipId", scholarshipId));
		if (criteria.list().size() != 0) {
			tasks = criteria.list();
		}
		session.close();
		return tasks;
	}

	@SuppressWarnings("unchecked")
	public List<Task> getTaskByRequestId(int requestId) {
		List<Task> tasks = null;
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Task.class);
		criteria.add(Restrictions.eq("requestId", requestId));
		if (criteria.list().size() != 0) {
			tasks = criteria.list();
		}
		session.close();
		return tasks;
	}
}
