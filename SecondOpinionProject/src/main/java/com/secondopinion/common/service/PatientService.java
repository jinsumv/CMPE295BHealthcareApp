package com.secondopinion.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.secondopinion.common.dao.PatientDao;
import com.secondopinion.common.dao.UserDao;
import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.PatientMedication;
import com.secondopinion.common.model.User;

@Component
public class PatientService {
	
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private UserDao userDao;
	
	public void createPatient(User user, Patient patient) {
		patientDao.insert(user,patient);		
	}
	
	public Patient findPatient(User user) {
		return patientDao.findByUserId(user.getUserId());
	}
	
	public Patient getCurrentPatient() {
		org.springframework.security.core.userdetails.User loggedInUser = (org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = loggedInUser.getUsername();
		User user = userDao.findByUserName(name);
		return findPatient(user);
	}

	public void updatePatient(Patient patient) {
		patientDao.updatePatient(patient);
	}
	
	public List<PatientMedication> getPatientMedations(Patient patient) {
		return patientDao.fetchPatientMedications(patient.getPatientId());
	}
	
	public void addPatientMedation(Patient patient, PatientMedication patientMedication) {
		patientDao.insertPatientMedication(patient, patientMedication);
	}
	
	public void removePatientMedication(int medicationId) {
		patientDao.deletePatientMedication(medicationId);
	}

}
