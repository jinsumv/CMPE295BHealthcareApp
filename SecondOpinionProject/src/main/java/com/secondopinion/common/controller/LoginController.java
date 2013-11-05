package com.secondopinion.common.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class LoginController {
 
	@RequestMapping(value="/welcome.do", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
 
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();
	
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security login + database example");
		return "home";
 
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