package com.secondopinion.common.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.User;
import com.secondopinion.common.service.DoctorService;
import com.secondopinion.common.service.PatientService;
import com.secondopinion.common.service.UserService;


/**
 * This is the core of the TravelLog functionality.  It's a Spring controller implemented
 * using annotations.  Most methods for loading and storing journals, entries, comments and photos
 * are initiated in this class.
 */
@Controller
public class DoctorController {

    private static final Logger logger=Logger.getLogger(DoctorController.class.getName());
    
    @Autowired
    UserService userService;
    
    @Autowired
    DoctorService doctorService;
    
    @RequestMapping(value = "/doctorsignup.do", method = RequestMethod.POST)
    public ModelAndView doPatientAccount (ModelMap map,
      @RequestParam("email") String email,
      @RequestParam("pwd") String password,
      @RequestParam("fullname") String fullName,
      @RequestParam("dateofbirth") String dateOfBirth,
      @RequestParam("gender") String gender,
      @RequestParam("qualifyingdegree") String qualifyingDegree,
      @RequestParam("areaofpractice") String areaOfPractice,
      @RequestParam("licensenumber") String licenseNumber,
      @RequestParam("achievements") String achievements) throws ParseException {

    	User user = new User( -1, email, password, true);
        user = userService.createUser(user);
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date dob = dateFormatter.parse(dateOfBirth);
        Doctor doctor = new Doctor(-1, -1, fullName, dob, gender, qualifyingDegree, areaOfPractice, licenseNumber, achievements);
        
        doctorService.createDoctor(user, doctor);
        return new ModelAndView("redirect:welcome.do");
    }
    
    @RequestMapping(value="/doctorprofile.do", method={RequestMethod.GET})
    public void doDoctorProfile (ModelMap model) {
    	Doctor doctor = doctorService.getCurrentDoctor();
		model.addAttribute("doctor", doctor);
    }
    
    @RequestMapping(value="/searchdoc.do", method={RequestMethod.GET})
    public void doSearch (ModelMap model) {
   
    }  

    @RequestMapping(value="/doctorsearchlist.do", method={RequestMethod.GET})
    public void doDocSearchList (ModelMap model) {
   
    }  

}
