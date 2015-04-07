package com.aeries.ams.service;

import com.aeries.ams.persistence.entity.User;

public interface UserService {

	public User getLoggedInUserDetails();
}
