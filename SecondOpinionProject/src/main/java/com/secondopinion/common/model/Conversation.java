package com.secondopinion.common.model;

import java.util.Date;

public class Conversation {
	int conversationId;
	int patientId;
	Integer doctorId;
	String title;
	Date startDate;
	Date updateDate;
	boolean unAnswered;
	
	public Conversation(int conversationId, int patientId, Integer doctorId,
			String title, Date startDate, Date updateDate, boolean unAnswered) {
		super();
		this.conversationId = conversationId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.title = title;
		this.startDate = startDate;
		this.updateDate = updateDate;
		this.unAnswered = unAnswered;
	}
	public int getConversationId() {
		return conversationId;
	}
	public int getPatientId() {
		return patientId;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public String getTitle() {
		return title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public boolean isUnAnswered() {
		return unAnswered;
	}

	
}
