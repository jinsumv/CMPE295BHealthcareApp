package com.secondopinion.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.secondopinion.common.dao.DoctorDao;
import com.secondopinion.common.dao.UserDao;
import com.secondopinion.common.model.Doctor;
import com.secondopinion.common.model.User;

@Component
public class DoctorService {
	
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private UserDao userDao;
	
	public void createDoctor(User user, Doctor doctor) {
		doctorDao.insert(user,doctor);		
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

}
