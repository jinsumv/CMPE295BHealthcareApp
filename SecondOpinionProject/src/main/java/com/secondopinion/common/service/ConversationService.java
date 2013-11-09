package com.secondopinion.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.secondopinion.common.dao.ConversationDao;
import com.secondopinion.common.dao.PatientDao;
import com.secondopinion.common.dao.UserDao;
import com.secondopinion.common.model.Comment;
import com.secondopinion.common.model.Conversation;
import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.PatientMedication;
import com.secondopinion.common.model.User;

@Component
public class ConversationService {
	
	@Autowired
	private ConversationDao conversationDao;
	
	@Autowired
	private UserDao userDao;
	
	public void askAQuestion(Conversation conversation, Comment comment) {
		conversationDao.createConversation(conversation);
		Conversation updatedConversation = conversationDao.getNewConversation();
		conversationDao.addComment(updatedConversation, comment);
	}

	public List<Conversation> getAllMessages(Patient patient) {
		List<Conversation> conversationList = conversationDao.getAllConversationsForPatient(patient.getPatientId());
		return conversationList;
	}
	
	public List<Conversation> getAllMessages(Doctor doctor) {
		List<Conversation> conversationList = conversationDao.getAllConversationsInvolvingUser(doctor.getUserId());
		return conversationList;
	}
	
	public Conversation getMessage(int conversationId) {
		Conversation conversation = conversationDao.getConversationForConversationId(conversationId);
		return conversation;
	}
	
	public List<Comment> getComments(int conversationId) {
		List<Comment> commentList = conversationDao.getCommentsForConversationId(conversationId);
		return commentList;
	}
	
	public void addComment(Conversation conversation, Comment comment) {
		conversationDao.addComment(conversation, comment);
	}
}
