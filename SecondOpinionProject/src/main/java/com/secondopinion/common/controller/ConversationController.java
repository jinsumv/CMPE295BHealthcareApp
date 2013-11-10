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
    public void doAskQuestion (ModelMap model,
    		@RequestParam(value="doctorid", required=false) Integer doctorId) {
    	if (doctorId != null) {
    		Doctor doctor = doctorService.findDoctor(doctorId);
    		model.addAttribute("doctor", doctor);
    	}
    }
    
    @RequestMapping(value="/listmessages.do", method={RequestMethod.GET})
    public String doListMessages (ModelMap model) {
    	Patient patient = patientService.getCurrentPatient();
    	List<Conversation> conversationList = conversationService.getAllMessages(patient);
    	model.addAttribute("conversationList", conversationList);
    	return "listmessages";
    }
    
    @RequestMapping(value="/listdoctormessages.do", method={RequestMethod.GET})
    public String doListDoctorMessages (ModelMap model) {
    	Doctor doctor = doctorService.getCurrentDoctor();
    	List<Conversation> conversationList = conversationService.getAllMessages(doctor);
    	model.addAttribute("conversationList", conversationList);
    	return "listdoctormessages";
    }
    
    @RequestMapping(value="/viewmessage.do", method={RequestMethod.GET})
    public String doViewMessage (ModelMap model,
    		@RequestParam("conversationid") int conversationId) {
    	Conversation conversation = conversationService.getMessage(conversationId);
    	Patient patient = patientService.findPatient(conversation.getPatientId());
    	conversation.setPatient(patient);
    	if (conversation.getDoctorId() != null || conversation.getDoctorId() != 0) {
    		Doctor doctor = doctorService.findDoctor(conversation.getDoctorId());
    		conversation.setDoctor(doctor);
    	}
    	
    	List<Comment> commentList = conversationService.getComments(conversationId);
    	for (Comment comment : commentList) {
    		User user = new User(comment.getUserId());
    		Patient patient1 = patientService.findPatient(user);
    		if (patient1 != null) {
    			comment.setCommenter(patient1);
    		}
    		else {
    			Doctor doctor1 = doctorService.findDoctor(user);
    			comment.setCommenter(doctor1);
    		}
    	}
    	model.addAttribute("conversation", conversation);
    	model.addAttribute("commentList", commentList);
    	
    	Doctor doctor = doctorService.getCurrentDoctor();
    	if (doctor != null) {
    		model.addAttribute("showreplybox", true);
    	}
    	else {
    		model.addAttribute("showreplybox", false);
    	}
    	return "viewmessage";
    }
    
    @RequestMapping(value="/addcomment.do", method={RequestMethod.POST})
    public ModelAndView doAddComment (ModelMap model,
    		@RequestParam("replytext") String commentText,
    		@RequestParam("conversationid") int conversationId) {
    	Conversation conversation = conversationService.getMessage(conversationId);
    	
    	Comment comment = null;
    	Patient patient = patientService.getCurrentPatient();
		if (patient != null) {
			comment = new Comment(-1, -1, patient.getUserId(), commentText, new Date());
		}
		else {
			Doctor doctor = doctorService.getCurrentDoctor();
			comment = new Comment(-1, -1, doctor.getUserId(), commentText, new Date());
		}
    	
    	conversationService.addComment(conversation, comment);
    	
    	
    	return new ModelAndView("redirect:viewmessage.do?conversationid="+conversationId);
    }
    
    @RequestMapping(value="/topmessages.do", method={RequestMethod.GET})
    public String doTopMessages (ModelMap model) {
    	List<Conversation> conversationList = conversationService.getMostRecentConversations();
    	model.addAttribute("conversationList", conversationList);
    	return "topmessages";
    }
    
    
}
