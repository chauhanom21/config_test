package com.aeries.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeries.ams.model.EmpRegForm;
import com.aeries.ams.persistence.dao.EmployeeDao;
import com.aeries.ams.persistence.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<EmpRegForm> getAllEmployees() {
		final List<EmpRegForm> empList = new ArrayList<>();
		final List<Employee> employees = employeeDao.getAllEmployees();
		if(employees != null && employees.size() > 0) {
			for(Employee emp : employees) {
				EmpRegForm empReg = new EmpRegForm();
				empReg.setEmpId(emp.getId());
				empReg.setFirstname(emp.getFistname());
				empReg.setLastname(emp.getLastname());
				empReg.setEmail(emp.getEmail());
				empList.add(empReg);
			}
		}
		return empList;
	}

}
