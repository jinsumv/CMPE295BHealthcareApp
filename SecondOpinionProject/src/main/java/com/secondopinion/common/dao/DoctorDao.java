package com.secondopinion.common.dao;

import java.util.List;

import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.DoctorDetails;
import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.Review;
import com.secondopinion.common.model.User;

public interface DoctorDao {
	public void insert(User user, Doctor doctor);
	public Doctor findByDoctorId(int doctorId);
	Doctor findByUserId(int userId);
	List<Doctor> findBySpeciality(String speciality);
	void followDoctor(Patient patient, Doctor doctor);
	List<Doctor> getFollowedDoctors(int patientId);
	int getFollowersCount(int doctorId);
	void addReview(Review review);
	List<Review> getReviewsForDoctor(int doctorId);
	public List<Doctor> findByName(String doctorname);
	public void updateDoctorBiography(DoctorDetails doctorDetails);
	public void updateDoctorPracticeInformation(DoctorDetails doctorDetails);
	public void updateDoctorEducation(DoctorDetails doctorDetails);
	public DoctorDetails getDoctorDetails(int doctorId);
	Doctor getNewDoctor();
	void insertDoctorDetails(Doctor doctor);
}
