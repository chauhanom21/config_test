package com.aeries.ams.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aeries.ams.persistence.entity.User;
import com.aeries.ams.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		return "user_login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String getAccessDeniedPage(Model model) {
		return "access_denied";
	}

	@RequestMapping("/userhome")
	public void getAuditTasks(HttpServletRequest request, HttpServletResponse response) {
		final User user = userService.getLoggedInUserDetails();
		
		final String userPage = getUserHomePageByRole(user);
		System.out.println(" UserPAge: "+userPage);
		RequestDispatcher rd = request.getRequestDispatcher(userPage);  
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}

	/**
	 * 
	 * @param user
	 * @return Logged-in user home page
	 */
	private String getUserHomePageByRole(final User user) {
		String homePage = "";
		if (user != null) {
			//final String role = user.getUserRole().getRoles();

			final String role = "hr";
			switch (role) {
			case "user":
				homePage = "employee";
				break;
			case "hr":
				homePage = "hr";
				break;
			case "admin":
				homePage = "admin";
				break;
			case "manager":
				homePage = "manager";
				break;
			default:
				homePage = "login";
				break;
			}

		}
		return homePage;
	}
}
