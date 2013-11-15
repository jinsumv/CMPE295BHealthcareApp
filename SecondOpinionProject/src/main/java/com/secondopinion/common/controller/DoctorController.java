package com.secondopinion.common.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

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
    		HttpServletRequest request,
      @RequestParam("email") String email,
      @RequestParam("pwd") String password,
      @RequestParam("fullname") String fullName,
      @RequestParam("dateofbirth") String dateOfBirth,
      @RequestParam("gender") String gender,
      @RequestParam("qualifyingdegree") String qualifyingDegree,
      @RequestParam("areaofpractice") String areaOfPractice,
      @RequestParam("licensenumber") String licenseNumber,
      @RequestParam("achievements") String achievements,
      @RequestParam("recaptcha_challenge_field") String challenge,
      @RequestParam("recaptcha_response_field") String response) throws ParseException {
    	
    	String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LfARuoSAAAAAKoszbmVYYkidNNvv-3kWQhcghpd");
        
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, response);

        if (reCaptchaResponse.isValid()) {
          System.out.println("Answer was entered correctly!");
        } else {
          System.out.println("Answer is wrong");
        }

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
    public void doDocSearchList (ModelMap model,
    		@RequestParam("speciality") String speciality) {
    	List<Doctor> doctorList = doctorService.findDoctorBySpeciality(speciality);
    	model.addAttribute("doctorList", doctorList);
    } 
    
    @RequestMapping(value="/doctordetails.do", method={RequestMethod.GET})
    public void doDoctorProfile (ModelMap model,
    		@RequestParam("doctorid") int doctorId) {
    	Doctor doctor = doctorService.findDoctor(doctorId);
		model.addAttribute("doctor", doctor);
    }

}
