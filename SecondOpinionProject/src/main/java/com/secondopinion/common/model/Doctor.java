package com.secondopinion.common.model;

import java.util.Date;

public class Doctor implements Person {
	int doctorId;
	int userId;
	String name;
	Date dateOfBirth;
	String gender;
	String qualifyingDegree;
	String areaOfPractice;
	String licenseNumber;
	String achievements;
	
	public Doctor(int doctorId, int userId, String name, Date dateOfBirth,
			String gender, String qualifyingDegree, String areaOfPractice,
			String licenseNumber, String achievements) {
		super();
		this.doctorId = doctorId;
		this.userId = userId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.qualifyingDegree = qualifyingDegree;
		this.areaOfPractice = areaOfPractice;
		this.licenseNumber = licenseNumber;
		this.achievements = achievements;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public int getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public String getQualifyingDegree() {
		return qualifyingDegree;
	}
	public String getAreaOfPractice() {
		return areaOfPractice;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public String getAchievements() {
		return achievements;
	}
	
}
