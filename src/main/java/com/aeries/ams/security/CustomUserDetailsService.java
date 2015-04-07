package com.aeries.ams.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.aeries.ams.persistence.dao.UserDAO;
import com.aeries.ams.persistence.entity.Roles;
import com.aeries.ams.persistence.entity.UserRole;

public class CustomUserDetailsService implements UserDetailsService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		com.aeries.ams.persistence.entity.User domainUser = userDAO
				.loadUserByUsernameAndStatus(username, "active");

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		final UserRole userRole = userDAO.getUserRoleByUserId(domainUser
				.getEmpId());
		final Roles role = userDAO.getRoleById(userRole.getRoleId());

		return new User(domainUser.getUsername(), domainUser.getPassword(),
				enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, getAuthorities(role.getRoleName()));
	}

	public Collection<? extends GrantedAuthority> getAuthorities(String role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}

	public List<String> getRoles(String role) {

		List<String> roles = new ArrayList<String>();

		if (role.equalsIgnoreCase("admin")) {
			roles.add("ADMIN");
		} else if (role.equalsIgnoreCase("user")) {
			roles.add("USER");
		} else if (role.equalsIgnoreCase("hr")) {
			roles.add("HR");
		} else if (role.equalsIgnoreCase("manager")) {
			roles.add("MANAGER");
		}
		return roles;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}
