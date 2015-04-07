package com.aeries.ams.service;

import com.aeries.ams.persistence.dao.UserDAO;
import com.aeries.ams.persistence.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	public User getLoggedInUserDetails() {
		User userDetails = null;

		final Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		final Object myUser = (auth != null) ? auth.getPrincipal() : null;

		if (myUser instanceof org.springframework.security.core.userdetails.User) {
			final org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) myUser;

			userDetails = userDao.loadUserByUsername(user.getUsername());

		}
		return userDetails;
	}
}
