package com.aeries.ams.persistence.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.aeries.ams.persistence.entity.Roles;
import com.aeries.ams.persistence.entity.User;
import com.aeries.ams.persistence.entity.UserRole;

@Service
public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public User loadUserByUsername(final String username) {
		System.out.println("username: " + username);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			final String selectQuery = "select p from User p WHERE p.username = :username";
			final Query query = session.createQuery(selectQuery);
			query.setParameter("username", username);
			final Object result = query.uniqueResult();
			if (result != null) {
				return (User) result;
			}

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}

	@Override
	public User loadUserByUsernameAndStatus(final String username,
			final String status) {
		System.out.println("username: " + username);
		Session session = null;
		try {
			session = sessionFactory.openSession();
			final String selectQuery = "select p from User p WHERE p.username =:username AND p.status =:status";
			final Query query = session.createQuery(selectQuery);
			query.setParameter("username", username);
			query.setParameter("status", status);
			final Object result = query.uniqueResult();
			if (result != null) {
				return (User) result;
			}

		} catch (final Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}

	@Override
	public UserRole getUserRoleByUserId(final Integer userId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			final Query query = session.createQuery("SELECT p FROM UserRole p"
					+ " WHERE p.userId =:userId");
			query.setParameter("userId", userId);
			query.setMaxResults(1);
			final Object result = query.uniqueResult();
			if (result != null)
				return (UserRole) result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	@Override
	public Roles getRoleById(final Integer roleId){
		Session session = null;
		try {
			session = sessionFactory.openSession();
			final Object result = session.get(Roles.class , roleId);
			if(result != null)
			return (Roles)result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeSession(session);
		}	
		return null;
	}

	private void closeSession(Session session) {
		if (session != null && session.isOpen()) {
			session.close();
		}
	}

}
