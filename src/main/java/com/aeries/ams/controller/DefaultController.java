package com.aeries.ams.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aeries.ams.model.EmpRegForm;
import com.aeries.ams.service.EmployeeService;


@Controller
public class DefaultController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getdata() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView gethome() {
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView getlogout(HttpServletRequest request) {
		removeUserSession(request);
		ModelAndView model = new ModelAndView("index");
		return model;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminHomePage(Model model) {
		return "admin_home";

	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getEmployeeHomePage(Model model) {
		model.addAttribute("employee", new EmpRegForm()); 
		return "employee_home";
	}
	
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String getManagerHomePage(Model model) {
		model.addAttribute("manager", new EmpRegForm()); 
		return "manager_home";
	}
	
	@RequestMapping(value = "/hr", method = RequestMethod.GET)
	public String getHrHomePage(Model model) {
		model.addAttribute("hr", new EmpRegForm()); 
		return "hr_home";
	}

//	@RequestMapping(value = "/patientlogin", method = RequestMethod.GET)
//	public String getPatientlogin(Model model, HttpServletRequest request) {
//		model.addAttribute("userBean", new UserBean()); 
//		return "patientlogin";
//	}
	
//	@RequestMapping(value = "/patienthome", method = RequestMethod.GET)
//	public String getpatienthome(Model model) {
//		model.addAttribute("resisterTest", new TestCollectionForm()); 
//		return "registertest";
//	}
//	
//	@RequestMapping(value = "/regtest", method = RequestMethod.GET)
//	public String getPatientRegtestPage(Model model, HttpServletRequest request) {
//		final UserRegForm user = getLoggedinUser(request);
//		if(user != null) {
//			Long userId = user.getId();
//			List<TestCollectionForm> patientTest =  DBUtility.getAllPatientTest(userId);
//			model.addAttribute("resisterTest", new TestCollectionForm()); 
//			return "registertest";
//		} else {
//			model.addAttribute("userBean", new UserBean()); 
//			return "patientlogin";
//		}
//		
//	}
//	
//	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
//	public String patientLogin(@ModelAttribute("userBean") UserBean userBean,
//			BindingResult bindingResult, Model model, HttpServletRequest request) {
//		model.addAttribute("userBean", userBean);
//		final boolean isLogin = DBUtility.verifyPatient(userBean);
//		if (isLogin) {
//			final UserRegForm user = DBUtility.getUserbyemail(userBean.getUsername());
//			setUserSession(request, user);
//			model.addAttribute("resisterTest", new TestCollectionForm());
//			return "patienthome";
//		} else {
//			model.addAttribute("patientLoginError", "Login Failed! Try Again !");
//			return "patientlogin";
//		}
//	}
//	
//	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
//	public String userRegister(@ModelAttribute("regForm") UserRegForm regForm,
//			BindingResult bindingResult, Model model) {
//		model.addAttribute("patient", regForm);
//		final boolean isexist = DBUtility.verifyPatientbyemail(regForm
//				.getEmail());
//		if (isexist) {
//			model.addAttribute("patientRegError",
//					"Registration Failed! User email already exists!");
//			return "patient";
//		}
//		final long patientId = DBUtility.savePatient(regForm);
//		if (patientId > 0) {
//			model.addAttribute("patientRegId", regForm.getEmail());
//			return "patient";
//		} else {
//			model.addAttribute("patientRegError",
//					"Registration Failed Try Again After Some Time!");
//			return "patient";
//		}
//	}
//	
//	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
//	public String getAdminLogin(@ModelAttribute("userBean") UserBean userBean,
//			 BindingResult bindingResult, Model model) {
//	
//		model.addAttribute("admin", userBean); 
//		boolean isAdmin = DBUtility.verifyAdmin(userBean);
//		if(isAdmin) {
//			model.addAttribute("adminLogin", true); 
//			return "adminhome";
//		}
//		model.addAttribute("adminLogin", false); 
//		return "admin";
//	}
//	@RequestMapping(value = "/viewpatient", method = RequestMethod.GET)
//	public String viewpatient(Model model) {
//		List<UserRegForm> patients =  DBUtility.getAllRegisterUsers();
//		model.addAttribute("patients",patients); 
//		return "viewpatients";
//	}
//	
	@RequestMapping(value ="viewemployees", method = RequestMethod.GET)
	public String viewEmployeeDetail(Model model) {
		List<EmpRegForm> employees = employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		//model.addAttribute("employees" employees);
		return "view_employees";
	}
	
	
//	@RequestMapping(value = "/viewresult", method = RequestMethod.GET)
//	public String viewTestresult(Model model, HttpServletRequest request) {
//		final UserRegForm user = getLoggedinUser(request);
//		if(user != null) {
//			Long userId = user.getId();
//			List<TestCollectionForm> patientTest =  DBUtility.getAllPatientTest(userId);
//			model.addAttribute("patientTest",patientTest); 
//			return "viewresults";
//		} else {
//			model.addAttribute("userBean", new UserBean()); 
//			return "patientlogin";
//		}
//	}
//	
//	@RequestMapping(value = "/uploadreport", method = RequestMethod.GET)
//	public String uploadreport(Model model) {
//		model.addAttribute("uploadForm", new UploadReport()); 
//		return "uploadreport";
//	}
	
	
	private void setUserSession(HttpServletRequest request, EmpRegForm user){
		HttpSession session = request.getSession();
		session.setAttribute("user_obj", user);
	}
	
	private void removeUserSession(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("user_obj");
	}
	
	private EmpRegForm getLoggedinUser(HttpServletRequest request){
		HttpSession session = request.getSession();
		return (EmpRegForm)session.getAttribute("user_obj");
	}

}