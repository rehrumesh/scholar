package com.scholar.rest.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.dao.RequestDao;
import com.scholar.rest.model.Request;

public class RequestDaoImpl implements RequestDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;;
	Transaction transaction = null;

	public void addRequest(Request request) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(request);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Request> getRequestList() throws Exception {
		session = sessionFactory.openSession();
		List<Request> requestList = session.createCriteria(Request.class)
				.list();
		session.close();
		return requestList;
	}

	@SuppressWarnings("unchecked")
	public List<Request> getRequestList(int requesterId) throws Exception {
		List<Request> requestList = null;
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Request.class);
		criteria.add(Restrictions.eq("requestedBy", requesterId));
		if (criteria.list().size() != 0) {
			requestList = criteria.list();
		}
		session.close();
		return requestList;
	}

	public void updateRequest(Request request) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Query query = session
				.createQuery("from request where requestId = :requestId");
		query.setParameter("requestId", request.getRequestId());
		Request requestToUpdate = (Request) query.list().get(0);
		if (!request.getDescription().equals("")) {
			requestToUpdate.setDescription(request.getDescription());
		}
		if (request.getAmount() > 0) {
			requestToUpdate.setAmount(request.getAmount());
		}
		if (request.getDuration() > 0) {
			requestToUpdate.setDuration(request.getDuration());
		}
		session.update(requestToUpdate);
		transaction.commit();
		session.close();
	}

	public void deleteRequest(int requestId) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Object requestToDelete = session.load(Request.class, requestId);
		session.delete(requestToDelete);
		transaction.commit();
		session.close();
	}
}
