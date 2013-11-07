package com.secondopinion.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.secondopinion.common.model.Patient;
import com.secondopinion.common.service.DoctorService;
import com.secondopinion.common.service.PatientService;
 
@Controller
public class LoginController {
	
	@Autowired
    PatientService patientService;
 
	@RequestMapping(value="/welcome.do", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
	
		model.addAttribute("username", name);
		Patient patient = patientService.getCurrentPatient();
		if (patient != null) {
			return "home";
		}
		else {
			return "doctorhome";
		}
 
	}
 
	@RequestMapping(value="/signin.do", method = RequestMethod.GET)
	public String login(ModelMap model) {
 
		return "signin";
 
	}
	
	@RequestMapping(value="/loginfailed.do", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
 
		model.addAttribute("error", "true");
		return "signin";
 
	}
	
	@RequestMapping(value="/logout.do", method = RequestMethod.GET)
	public String logout(ModelMap model) {
 
		return "signin";
 
	}
	
	@RequestMapping(value="/forgotpassword.do", method={RequestMethod.GET})
    public void doForgotPassword (ModelMap model) {
        
    }   

    @RequestMapping(value="/registration.do", method={RequestMethod.GET})
    public void doRegistration (ModelMap model) {
        
    } 
	
}