package com.secondopinion.common.model;

import java.util.Date;

public class Review {
	int reviewId;
	int patientId;
	int doctorId;
	String text;
	Date reviewDate;
	int rate;
	
	Doctor doctor;
	Patient patient;
	
	public Review(int reviewId, int patientId, int doctorId, String text,
			Date reviewDate, int rate) {
		super();
		this.reviewId = reviewId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.text = text;
		this.reviewDate = reviewDate;
		this.rate = rate;
	}
	public int getReviewId() {
		return reviewId;
	}
	public int getPatientId() {
		return patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public String getText() {
		return text;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
