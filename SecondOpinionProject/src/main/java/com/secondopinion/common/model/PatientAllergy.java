package com.secondopinion.common.model;

public class PatientAllergy {
	public final int patientAllergyId;
	public final int patientId;
	public final String allergyName;
	public final String notes;
	
	public PatientAllergy(int patientAllergyId, int patientId,
			String allergyName, String notes) {
		this.patientAllergyId = patientAllergyId;
		this.patientId = patientId;
		this.allergyName = allergyName;
		this.notes = notes;
	}
	public int getPatientAllergyId() {
		return patientAllergyId;
	}
	public int getPatientId() {
		return patientId;
	}
	public String getAllergyName() {
		return allergyName;
	}
	public String getNotes() {
		return notes;
	}
}
