package com.secondopinion.common.dao;

import java.util.List;

import com.secondopinion.common.model.Patient;
import com.secondopinion.common.model.PatientFile;
import com.secondopinion.common.model.PatientMedication;
import com.secondopinion.common.model.PatientSymptom;
import com.secondopinion.common.model.User;

public interface PatientDao {
	public void insert(User user, Patient patient);
	public Patient findByPatientId(int patientId);
	Patient findByUserId(int userId);
	public void updatePatient(Patient patient);
	List<PatientMedication> fetchPatientMedications(int patientId);
	void insertPatientMedication(Patient patient,
			PatientMedication patientMedication);
	void deletePatientMedication(int medicationId);
	void insertPatientFile(Patient patient, PatientFile patientFile);
	public void insertPatientSymptom(Patient patient,
			PatientSymptom patientSymptom);
	public void deletePatientSymptom(int symptomId);
	public List<PatientSymptom> fetchPatientSymptoms(int patientId);
}

