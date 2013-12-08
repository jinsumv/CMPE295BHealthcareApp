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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.secondopinion.common.model.Comment;
import com.secondopinion.common.model.Conversation;
import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.DoctorDetails;
import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.Review;
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
    
    @Autowired
    PatientService patientService;
    
    @RequestMapping(value = "/doctorsignup.do", method = RequestMethod.POST)
    public ModelAndView doDoctorAccount (ModelMap map,
    		@ModelAttribute("addDoctorForm")  Doctor doctor,			
    		BindingResult result,
    		HttpServletRequest request,
    		Model model,
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

        if (!reCaptchaResponse.isValid()) {
        	System.out.println("Captcha Answer is wrong");
			model.addAttribute("invalidRecaptcha", true);
			ModelAndView modelView = new ModelAndView("redirect:doctorregistration.do");
			return modelView;
        }

        System.out.println("Captcha Answer is correct");

    	User user = new User( -1, email, password, true);
        user = userService.createUser(user);
        
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        Date dob = dateFormatter.parse(dateOfBirth);
        doctor = new Doctor(-1, -1, fullName, dob, gender, qualifyingDegree, areaOfPractice, licenseNumber, achievements);
        
        doctorService.createDoctor(user, doctor);
        return new ModelAndView("redirect:welcome.do");
    }
    
    @RequestMapping(value="/doctorprofile.do", method={RequestMethod.GET})
    public void doDoctorProfile (ModelMap model) {
    	Doctor doctor = doctorService.getCurrentDoctor();
		model.addAttribute("doctor", doctor);
		
		DoctorDetails doctorDetais = doctorService.getDoctorDetails(doctor.getDoctorId());
		model.addAttribute("doctorDetails", doctorDetais);
		
		int followerCount = doctorService.getFollowersCount(doctor.getDoctorId());
		model.addAttribute("followercount", followerCount);
		
		List<Review> reviewList = doctorService.getReviewsForDoctor(doctor.getDoctorId());
		model.addAttribute("reviewcount", reviewList.size());
    }
    
    @RequestMapping(value="/searchdoc.do", method={RequestMethod.GET})
    public void doSearch (ModelMap model) {
   
    }

    @RequestMapping(value="/doctorsearchlist.do", method={RequestMethod.GET})
    public void doDocSearchList (ModelMap model,
    		@RequestParam("speciality") String speciality) {
    	Patient patient = patientService.getCurrentPatient();
		List<Doctor> followedDoctorsList = doctorService.getFollowedDoctors(patient.getPatientId());
    	
    	List<Doctor> doctorList = doctorService.findDoctorBySpeciality(speciality);
    	for (Doctor doctor : doctorList)
    	{
	    	List<Review> reviewList = doctorService.getReviewsForDoctor(doctor.getDoctorId());
    		int sumofratings = 0;
	    	for (Review review : reviewList) {
	    		sumofratings = sumofratings + review.getRate();
	    	}
	    	if (reviewList.size() > 0) {
	    		int docrating = sumofratings/reviewList.size();
	    		doctor.setRating(docrating);
	    	}
	    	
			for (Doctor followeddoctor : followedDoctorsList)
			{
				if (doctor.getDoctorId() == followeddoctor.getDoctorId()) {
					doctor.setFollowed(true);
					break;
				}
			}
	    }
    	
    	model.addAttribute("doctorList", doctorList);
    }
    
    @RequestMapping(value="/doctorsearchbyname.do", method={RequestMethod.GET})
    public String doDocSearchByName (ModelMap model,
    		@RequestParam("docname") String doctorname) {
    	Patient patient = patientService.getCurrentPatient();
		List<Doctor> followedDoctorsList = doctorService.getFollowedDoctors(patient.getPatientId());
    	
    	List<Doctor> doctorList = doctorService.findDoctorByName(doctorname);
    	for (Doctor doctor : doctorList)
    	{
	    	List<Review> reviewList = doctorService.getReviewsForDoctor(doctor.getDoctorId());
    		int sumofratings = 0;
	    	for (Review review : reviewList) {
	    		sumofratings = sumofratings + review.getRate();
	    	}
	    	if (reviewList.size() > 0) {
	    		int docrating = sumofratings/reviewList.size();
	    		doctor.setRating(docrating);
	    	}
	    	for (Doctor followeddoctor : followedDoctorsList)
			{
				if (doctor.getDoctorId() == followeddoctor.getDoctorId()) {
					doctor.setFollowed(true);
					break;
				}
			}
	    }
    	model.addAttribute("doctorList", doctorList);
    	return "doctorsearchlist";

    }
    
    @RequestMapping(value="/doctordetails.do", method={RequestMethod.GET})
    public void doDoctorProfile (ModelMap model,
    		@RequestParam("doctorid") int doctorId) {
    	Doctor doctor = doctorService.findDoctor(doctorId);
    	
    	/*Get doctor rating count*/
    	List<Review> reviewList = doctorService.getReviewsForDoctor(doctor.getDoctorId());
		int sumofratings = 0;
    	for (Review review : reviewList) {
    		sumofratings = sumofratings + review.getRate();
    	}
    	if (reviewList.size() > 0) {
    		int docrating = sumofratings/reviewList.size();
    		doctor.setRating(docrating);
    	}
    	model.addAttribute("doctor", doctor);
    	
    	DoctorDetails doctorDetais = doctorService.getDoctorDetails(doctor.getDoctorId());
		model.addAttribute("doctorDetails", doctorDetais);
		
		Patient patient = patientService.getCurrentPatient();
		List<Doctor> doctorList = doctorService.getFollowedDoctors(patient.getPatientId());
		model.addAttribute("showfollowbutton", true);
		for (Doctor followeddoctor : doctorList)
		{
			if (doctor.getDoctorId() == followeddoctor.getDoctorId()) {
				model.addAttribute("showfollowbutton", false);
				break;
			}
		}
		
		int followerCount = doctorService.getFollowersCount(doctorId);
		model.addAttribute("followercount", followerCount);
		
		List<Review> reviewList1 = doctorService.getReviewsForDoctor(doctorId);
		model.addAttribute("reviewcount", reviewList1.size());
    }
    
    @RequestMapping(value = "/followdoctor.do", method = RequestMethod.GET)
    public ModelAndView doPatientAccount (ModelMap map,
      @RequestParam("doctorid") int doctorId) throws ParseException {

    	Patient patient = patientService.getCurrentPatient();
    	Doctor doctor = doctorService.findDoctor(doctorId);
        
        doctorService.followDoctor(patient, doctor);
        return new ModelAndView("redirect:followeddoctors.do");
    }
    
    @RequestMapping(value="/followeddoctors.do", method={RequestMethod.GET})
    public String doDocSearchList (ModelMap model) {
    	Patient patient = patientService.getCurrentPatient();
    	List<Doctor> doctorList = doctorService.getFollowedDoctors(patient.getPatientId());
    	
    	/* Get doctor rating count */
    	for(Doctor doctor : doctorList)
    	{
	    	List<Review> reviewList = doctorService.getReviewsForDoctor(doctor.getDoctorId());
			int sumofratings = 0;
	    	for (Review review : reviewList) {
	    		sumofratings = sumofratings + review.getRate();
	    	}
	    	if (reviewList.size() > 0) {
	    		int docrating = sumofratings/reviewList.size();
	    		doctor.setRating(docrating);
	    	}
	    	doctor.setFollowed(true);
    	}
    	model.addAttribute("doctorList", doctorList);
    	return "doctorsearchlist";
    }
    
    @RequestMapping(value="/reviewlist.do", method={RequestMethod.GET})
    public String doReviewList (ModelMap model,
    		@RequestParam("doctorid") int doctorId) {
    	List<Review> reviewList = doctorService.getReviewsForDoctor(doctorId);
    	for (Review review : reviewList) {
    		Patient patient = patientService.findPatient(review.getPatientId());
    		review.setPatient(patient);
    	}
    	model.addAttribute("reviewList", reviewList);
    	
    	Doctor doctor = doctorService.findDoctor(doctorId);
    	model.addAttribute("doctor", doctor);
    	
    	Patient patient = patientService.getCurrentPatient();
    	if (patient != null) {
    		model.addAttribute("showAddReview", true);
    	}else {
    		model.addAttribute("showAddReview", false);
    	}
    	
    	return "reviewlist";
    }
    
    @RequestMapping(value="/addreview.do", method={RequestMethod.POST})
    public ModelAndView doAddComment (ModelMap model,
    		@RequestParam("reviewtext") String reviewText,
    		@RequestParam("doctorid") int doctorId, 
    		@RequestParam("rating") int rating){
    	
    	Patient patient = patientService.getCurrentPatient();
    	
    	Review review = new Review(-1, patient.getPatientId(), doctorId, reviewText, new Date(), rating);
    	
    	doctorService.addReview(review);
    	
    	return new ModelAndView("redirect:reviewlist.do?doctorid="+doctorId);
    }
    
    @RequestMapping(value="/updatedoctorbiography.do", method={RequestMethod.POST})
    public ModelAndView doUpadteDoctorBiography (ModelMap model,
    		@RequestParam("areaOfPracticeName") String areaOfPracticeName,
    		@RequestParam("areaOfPracticeDetails") String areaOfPracticeDetails, 
    		@RequestParam("specialHonors1") String specialHonors1, 
    		@RequestParam("specialHonors2") String specialHonors2, 
    		@RequestParam("specialHonors3") String specialHonors3){
    	
    	Doctor doctor = doctorService.getCurrentDoctor();
    	
    	DoctorDetails doctorDetails = new DoctorDetails();
    	doctorDetails.setDoctorId(doctor.getDoctorId());
    	doctorDetails.setAreaOfPracticeName(areaOfPracticeName);
    	doctorDetails.setAreaOfPracticeDetails(areaOfPracticeDetails);
    	doctorDetails.setSpecialHonors1(specialHonors1);
    	doctorDetails.setSpecialHonors2(specialHonors2);
    	doctorDetails.setSpecialHonors3(specialHonors3);
    	
    	doctorService.updateDoctorBiography(doctorDetails);
    	
    	return new ModelAndView("redirect:doctorprofile.do");
    }
    
    @RequestMapping(value="/updatedoctorpracticeinfo.do", method={RequestMethod.POST})
    public ModelAndView doUpadteDoctorPracticeInfo (ModelMap model,
    		@RequestParam("practiceName") String practiceName,
    		@RequestParam("practiceAddress") String practiceAddress, 
    		@RequestParam("practiceCity") String practiceCity, 
    		@RequestParam("practiceState") String practiceState, 
    		@RequestParam("practiceZip") String practiceZip,
    		@RequestParam("practiceHours1") String practiceHours1,
    		@RequestParam("practiceHours2") String practiceHours2,
    		@RequestParam("website") String website){
    	
    	Doctor doctor = doctorService.getCurrentDoctor();
    	
    	DoctorDetails doctorDetails = new DoctorDetails();
    	doctorDetails.setDoctorId(doctor.getDoctorId());
    	doctorDetails.setPracticeName(practiceName);
    	doctorDetails.setPracticeAddress(practiceAddress);
    	doctorDetails.setPracticeCity(practiceCity);
    	doctorDetails.setPracticeState(practiceState);
    	doctorDetails.setPracticeZip(practiceZip);
    	doctorDetails.setPracticeHours1(practiceHours1);
    	doctorDetails.setPracticeHours2(practiceHours2);
    	doctorDetails.setWebsite(website);
    	
    	doctorService.updateDoctorPracticeInformation(doctorDetails);
    	
    	return new ModelAndView("redirect:doctorprofile.do");
    }
    
    @RequestMapping(value="/updatedoctoreducation.do", method={RequestMethod.POST})
    public ModelAndView doUpadteDoctorEducation (ModelMap model,
    		@RequestParam("residencies1") String residencies1,
    		@RequestParam("residencies2") String residencies2,
    		@RequestParam("residencies3") String residencies3,
    		@RequestParam("medicalSchool1") String medicalSchool1,
    		@RequestParam("medicalSchool2") String medicalSchool2,
    		@RequestParam("medicalSchool3") String medicalSchool3,
    		@RequestParam("affiliations1") String affiliations1, 
    		@RequestParam("affiliations2") String affiliations2, 
    		@RequestParam("affiliations3") String affiliations3){
    	
    	Doctor doctor = doctorService.getCurrentDoctor();
    	
    	DoctorDetails doctorDetails = new DoctorDetails();
    	doctorDetails.setDoctorId(doctor.getDoctorId());
    	doctorDetails.setResidencies1(residencies1);
    	doctorDetails.setResidencies2(residencies2);
    	doctorDetails.setResidencies3(residencies3);
    	doctorDetails.setMedicalSchool1(medicalSchool1);
    	doctorDetails.setMedicalSchool2(medicalSchool2);
    	doctorDetails.setMedicalSchool3(medicalSchool3);
    	doctorDetails.setAffiliations1(affiliations1);
    	doctorDetails.setAffiliations2(affiliations2);
    	doctorDetails.setAffiliations3(affiliations3);
    	
    	doctorService.updateDoctorEducation(doctorDetails);
    	
    	return new ModelAndView("redirect:doctorprofile.do");
    }

}
