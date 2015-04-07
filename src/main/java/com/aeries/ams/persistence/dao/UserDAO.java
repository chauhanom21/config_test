package com.aeries.ams.persistence.dao;

import com.aeries.ams.persistence.entity.Roles;
import com.aeries.ams.persistence.entity.User;
import com.aeries.ams.persistence.entity.UserRole;

public interface UserDAO {
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public User loadUserByUsername(final String username);
	
	/**
	 * 
	 * @param username
	 * @param status
	 * @return
	 */
	public User loadUserByUsernameAndStatus(final String username, final String status);
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public UserRole getUserRoleByUserId(final Integer userId);
	
	/**
	 * 
	 * @param roleId
	 * @return
	 */
	public Roles getRoleById(final Integer roleId);

}
