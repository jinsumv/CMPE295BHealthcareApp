package com.secondopinion.common.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.secondopinion.common.model.Comment;
import com.secondopinion.common.model.Conversation;
import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.User;
import com.secondopinion.common.service.ConversationService;
import com.secondopinion.common.service.DoctorService;
import com.secondopinion.common.service.PatientService;
import com.secondopinion.common.service.UserService;


/**
 * This is the core of the TravelLog functionality.  It's a Spring controller implemented
 * using annotations.  Most methods for loading and storing journals, entries, comments and photos
 * are initiated in this class.
 */
@Controller
public class ConversationController {

    private static final Logger logger=Logger.getLogger(ConversationController.class.getName());
    
    @Autowired
    UserService userService;
    
    @Autowired
    DoctorService doctorService;
    
    @Autowired
    PatientService patientService;
    
    @Autowired
    ConversationService conversationService;
    
    
    @RequestMapping(value = "/addNewQuestion.do", method = RequestMethod.POST)
    public ModelAndView doAddNewQuestion (ModelMap map,
      @RequestParam("title") String title,
      @RequestParam("question") String question,
      @RequestParam(value="doctorid", required=false) Integer doctorId) {
    	
    	Patient patient = patientService.getCurrentPatient();
    	
    	Conversation conversation = 
    			new Conversation(-1, patient.getPatientId(), doctorId, title, new Date(), new Date(), true); 
    	Comment comment = new Comment(-1, -1, patient.getUserId(), question, new Date());
    	
    	conversationService.askAQuestion(conversation, comment);
    	
        return new ModelAndView("redirect:welcome.do");
    }
    
    @RequestMapping(value="/askquestion.do", method={RequestMethod.GET})
    public void doAskQuestion (ModelMap model) {
   
    }
    
    @RequestMapping(value="/listmessages.do", method={RequestMethod.GET})
    public String doListMessages (ModelMap model) {
    	Patient patient = patientService.getCurrentPatient();
    	List<Conversation> conversationList = conversationService.getAllMessages(patient);
    	model.addAttribute("conversationList", conversationList);
    	return "listmessages";
    }
    
    
}
