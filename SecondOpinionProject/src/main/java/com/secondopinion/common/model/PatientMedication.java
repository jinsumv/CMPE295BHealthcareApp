package com.secondopinion.common.model;

public class PatientMedication {
	int patientMedicationId;
	int patientId;
	String medicationName;
	String notes;
	
	public PatientMedication(int patientMedicationId, int patientId,
			String medicationName, String notes) {
		super();
		this.patientMedicationId = patientMedicationId;
		this.patientId = patientId;
		this.medicationName = medicationName;
		this.notes = notes;
	}
	public int getPatientMedicationId() {
		return patientMedicationId;
	}
	public int getPatientId() {
		return patientId;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public String getNotes() {
		return notes;
	}
}
