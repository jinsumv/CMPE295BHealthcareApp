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
	int likes;
	int dislikes;
	
	Patient patient;
	Doctor doctor;
	Comment firstComment;
	
	public Conversation(int conversationId, int patientId, Integer doctorId,
			String title, Date startDate, Date updateDate, boolean unAnswered, int likes, int dislikes) {
		super();
		this.conversationId = conversationId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.title = title;
		this.startDate = startDate;
		this.updateDate = updateDate;
		this.unAnswered = unAnswered;
		this.likes = likes;
		this.dislikes = dislikes;
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
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Comment getFirstComment() {
		return firstComment;
	}
	public void setFirstComment(Comment firstComment) {
		this.firstComment = firstComment;
	}
	public int getLikes() {
		return likes;
	}
	public int getDislikes() {
		return dislikes;
	}
}
