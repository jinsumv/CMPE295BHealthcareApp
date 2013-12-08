package com.secondopinion.common.model;

import java.util.Calendar;
import java.util.Date;

public class Patient implements Person {
	int patientId;
	int userId;
	String name;
	Date dateOfBirth;
	String gender;
	String location;
	String profilePicUrl;
	
	
	public Patient() { } // Default constructor needed for Captcha
	
	public Patient(int patientId, int userId, String name, Date dateOfBirth,
			String gender, String location, String profilePicUrl) {
		super();
		this.patientId = patientId;
		this.userId = userId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.location = location;
		this.profilePicUrl = profilePicUrl;
	}
	
	public int getPatientId() {
		return patientId;
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
	public String getLocation() {
		return location;
	}
	public String getProfilePicUrl() {
		return profilePicUrl;
	}
	public int getAge() {
		Calendar dob = Calendar.getInstance();  
		dob.setTime(dateOfBirth);  
		Calendar today = Calendar.getInstance();  
		int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);  
		if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
		  age--;  
		} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
		    && today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)) {
		  age--;  
		}
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}
}
