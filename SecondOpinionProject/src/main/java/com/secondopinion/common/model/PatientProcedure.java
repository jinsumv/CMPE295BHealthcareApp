package com.secondopinion.common.model;

public class PatientProcedure {
	public final int patientProcedureId;
	public final int patientId;
	public final String procedureName;
	public final String notes;
	
	public PatientProcedure(int patientProcedureId, int patientId,
			String procedureName, String notes) {
		this.patientProcedureId = patientProcedureId;
		this.patientId = patientId;
		this.procedureName = procedureName;
		this.notes = notes;
	}
	public int getPatientProcedureId() {
		return patientProcedureId;
	}
	public int getPatientId() {
		return patientId;
	}
	public String getProcedureName() {
		return procedureName;
	}
	public String getNotes() {
		return notes;
	}
}
