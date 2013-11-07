package com.secondopinion.common.dao;

import java.util.List;

import com.secondopinion.common.model.Comment;
import com.secondopinion.common.model.Conversation;

public interface ConversationDao {
	
	void createConversation(Conversation conversation);
	void addComment(Conversation conversation, Comment comment);
	Conversation getConversationForConversationId(int conversationId);
	List<Comment> getCommentsForConversationId(int conversationId);
	Conversation getNewConversation();
	List<Conversation> getAllConversationsForPatient(int patientId);
}
