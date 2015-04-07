package com.aeries.ams.persistence.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeries.ams.persistence.entity.Employee;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Boolean saveOrUpdateEmployee(Employee emp) {
		Session session = null;
		Transaction txn = null;
		try {
			session = sessionFactory.openSession();
			txn = session.beginTransaction();
			session.saveOrUpdate(emp);
			txn.commit();
			return true;
		} catch(final HibernateException he){
			txn.rollback();
			he.printStackTrace();
		} finally {
			closeSession(session);
		}
		return false;
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Object result = session.get(Employee.class, empId);
			if(result != null)
				return (Employee)result;
		} catch(final HibernateException he){
			he.printStackTrace();
		} finally {
			closeSession(session);
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("FROM Employee");
			Object result = query.list();
			if(result != null)
				return (List<Employee>)result;
		} catch(final HibernateException he){
			he.printStackTrace();
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
