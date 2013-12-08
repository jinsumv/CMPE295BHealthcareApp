package com.secondopinion.common.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.secondopinion.common.dao.DoctorDao;
import com.secondopinion.common.dao.UserDao;
import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.DoctorDetails;
import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.Review;
import com.secondopinion.common.model.User;

@Component
public class DoctorService {
	private static final String BUCKET_NAME = "secondopinion";
	private static final int KEY_LENGTH = 10;

	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private UserDao userDao;
	
	public void createDoctor(User user, Doctor doctor) {
		doctorDao.insert(user,doctor);
		Doctor updatedDoctor = doctorDao.getNewDoctor();
		doctorDao.insertDoctorDetails(updatedDoctor);
	}
	
	public Doctor findDoctor(User user) {
		return doctorDao.findByUserId(user.getUserId());
	}
	
	public Doctor findDoctor(int doctorId) {
		return doctorDao.findByDoctorId(doctorId);
	}
	
	public Doctor getCurrentDoctor() {
		org.springframework.security.core.userdetails.User loggedInUser = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = loggedInUser.getUsername();
		User user = userDao.findByUserName(name);
		return findDoctor(user);
	}
	
	public List<Doctor> findDoctorBySpeciality(String speciality) {
		return doctorDao.findBySpeciality(speciality);
	}
	
	public void followDoctor(Patient patient, Doctor doctor) {
		doctorDao.followDoctor(patient, doctor);
	}

	public List<Doctor> getFollowedDoctors(int patientId) {
		return doctorDao.getFollowedDoctors(patientId);
	}
	
	public int getFollowersCount(int doctorId) {
		return doctorDao.getFollowersCount(doctorId);
	}
	
	public List<Review> getReviewsForDoctor(int doctorId) {
		return doctorDao.getReviewsForDoctor(doctorId);
	}
	
	public void addReview(Review review) {
		doctorDao.addReview(review);
	}

	public List<Doctor> findDoctorByName(String doctorname) {
		return doctorDao.findByName(doctorname);	
	}
	
	public DoctorDetails getDoctorDetails(int doctorId) {
		return doctorDao.getDoctorDetails(doctorId);
	}
	
	public void updateDoctorBiography(DoctorDetails doctorDetails) {
		doctorDao.updateDoctorBiography(doctorDetails);
	}
	
	public void updateDoctorPracticeInformation(DoctorDetails doctorDetails) {
		doctorDao.updateDoctorPracticeInformation(doctorDetails);
	}
	
	public void updateDoctorEducation(DoctorDetails doctorDetails) {
		doctorDao.updateDoctorEducation(doctorDetails);
	}

	public void updateProfilePic(Doctor doctor, MultipartFile file) throws IOException {
		String keyName = "profile_pictures/"
				+ RandomStringUtils.randomAlphanumeric(KEY_LENGTH);
		keyName += "/" + file.getOriginalFilename();
		AWSCredentials credentials = new PropertiesCredentials(
				DoctorService.class
						.getResourceAsStream("/AwsCredentials.properties"));
		System.out.println(credentials);
		AmazonS3 s3client = new AmazonS3Client(credentials);
		try {
			if (file.getSize() > 0) {
				InputStream in = file.getInputStream();
				Long contentLength = Long.valueOf(file.getSize());
				ObjectMetadata metadata = new ObjectMetadata();
				metadata.setServerSideEncryption(ObjectMetadata.AES_256_SERVER_SIDE_ENCRYPTION);
				metadata.setContentLength(contentLength);
				PutObjectRequest putRequest = new PutObjectRequest(BUCKET_NAME, keyName,
						in, metadata);
				putRequest.setCannedAcl(CannedAccessControlList.PublicRead);
				System.out.println("Setting public permissions to S3 object");
				
				s3client.putObject(putRequest);
				System.out.println("File Uploaded to S3");
				String url = "https://s3-us-west-2.amazonaws.com/secondopinion/"
						+ keyName;
				
				doctor.setProfilePicUrl(url);
				System.out.println(doctor.getProfilePicUrl());
				doctorDao.updateDoctor(doctor);
			}

		} catch (Exception e) {
			System.err.println("S3 Upload Error" + e.getMessage());
		}
		
	}
		
	}

