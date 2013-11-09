package com.secondopinion.common.model;

public class PatientSymptom {
	public final int patientSymptomId;
	public final int patientId;
	public final String symptomName;
	public final String notes;
	
	public PatientSymptom(int patientSymptomId, int patientId,
			String symptomName, String notes) {
		this.patientSymptomId = patientSymptomId;
		this.patientId = patientId;
		this.symptomName = symptomName;
		this.notes = notes;
	}
}
