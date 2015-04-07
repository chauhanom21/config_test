package com.aeries.ams.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "users")
public class User {

	@Id
	@Column(name = "emp_id")
	private Integer empId;

	@Column(name = "user_name")
	private String username;

	@Column(name = "password", insertable=false, updatable=false, 
            nullable=false)
	private String password;

	@Column(name = "status")
	private String status;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
