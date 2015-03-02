package com.scholar.rest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.scholar.rest.model.User;

public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction transaction = null;

	public void addUser(User user) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		session.save(user);
		transaction.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsersList() throws Exception {
		session = sessionFactory.openSession();
		List<User> users = session.createCriteria(User.class).list();
		session.close();
		return users;
	}

	public User getUserById(int userId) throws Exception {
		User user = null;
		session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("id", userId));
		if (criteria.list().size() != 0) {
			user = (User) criteria.list().get(0);
		}
		session.close();
		return user;
	}

	public void updateUser(User user) throws Exception {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from User where id = :userId ");
		query.setParameter("userId", user.getId());
		User userToUpdate = (User) query.list().get(0);
		if(!user.getFirstName().equals("")){
			userToUpdate.setFirstName(user.getFirstName());
		}
		if(!user.getLastName().equals("")){
			userToUpdate.setLastName(user.getLastName());
		}
		session.update(userToUpdate);
		transaction.commit();
		session.close();
	}

	public void deleteUser(int userId) throws Exception {
		session = sessionFactory.openSession();
		Object userTodelete = session.load(User.class, userId);
		transaction = session.beginTransaction();
		session.delete(userTodelete);
		transaction.commit();
		session.close();
	}
}
