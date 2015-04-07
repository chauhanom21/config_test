package com.aeries.ams.persistence.dao;

import java.util.List;

import com.aeries.ams.persistence.entity.Employee;

public interface EmployeeDao {

	/**
	 * 
	 * @param emp
	 */
	public Boolean saveOrUpdateEmployee(Employee emp);
	
	/**
	 * 
	 * @param empId
	 * @return
	 */
	public Employee getEmployeeById(final Integer empId);
	
	/**
	 * 
	 * @return
	 */
	public List<Employee> getAllEmployees();
}
