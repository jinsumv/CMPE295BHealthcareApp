package com.secondopinion.common.model;

import java.util.Date;

public class Comment {
	int commentId;
	int conversationId;
	int userId;
	String text;
	Date commentDate;
	
	Person commenter;
	
	public Comment(int commentId, int conversationId, int userId, String text,
			Date commentDate) {
		super();
		this.commentId = commentId;
		this.conversationId = conversationId;
		this.userId = userId;
		this.text = text;
		this.commentDate = commentDate;
	}
	public int getCommentId() {
		return commentId;
	}
	public int getConversationId() {
		return conversationId;
	}
	public int getUserId() {
		return userId;
	}
	public String getText() {
		return text;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public Person getCommenter() {
		return commenter;
	}
	public void setCommenter(Person commenter) {
		this.commenter = commenter;
	}
	
}
