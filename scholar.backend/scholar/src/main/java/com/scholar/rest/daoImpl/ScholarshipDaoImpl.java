package com.scholar.rest.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.dao.ScholarshipDao;
import com.scholar.rest.model.Scholarship;

public class ScholarshipDaoImpl implements ScholarshipDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction transaction = null;

	public void addScholarship(Scholarship scholarship) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(scholarship);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Scholarship> getScholarshipByOwnerId(int ownerId)
			throws Exception {
		List<Scholarship> scholarshipList = null;
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Scholarship.class);
		criteria.add(Restrictions.eq("createdBy", ownerId));
		if (criteria.list().size() != 0) {
			scholarshipList = criteria.list();
		}
		session.close();
		return scholarshipList;
	}

	public void updateScholarship(Scholarship scholarship) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Query query = session
				.createQuery("from scholarship where scholarshipId = :scholarshipId");
		query.setParameter("scholarshipId", scholarship.getScholarshipId());
		Scholarship scholarshipToUpdate = (Scholarship) query.list().get(0);
		if (!scholarship.getDescription().equals("")) {
			scholarshipToUpdate.setDescription(scholarship.getDescription());
		}
		if (scholarship.getAmount() > 0) {
			scholarshipToUpdate.setAmount(scholarship.getAmount());
		}
		if (scholarship.getDuration() > 0) {
			scholarshipToUpdate.setDuration(scholarship.getDuration());
		}
		session.update(scholarshipToUpdate);
		transaction.commit();
		session.close();
	}

	public void deleteScholarship(int scholarshipId) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Object scholarshipTodelete = session.load(Scholarship.class,
				scholarshipId);
		session.delete(scholarshipTodelete);
		transaction.commit();
		session.close();
	}

}
