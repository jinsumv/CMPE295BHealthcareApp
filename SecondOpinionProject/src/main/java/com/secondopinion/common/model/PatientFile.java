package com.secondopinion.common.model;


/**
 * Represents a file uploaded by patient.
 * 
 * @author jinsu
 */
public class PatientFile {
	public final int patientFileId;
	public final int patientId;
	public final String fileName;
	public final String description;
	public final String fileUrl;
	
	public PatientFile(int patientFileId, int patientId, String fileName,
			String description, String fileUrl) {
		this.patientFileId = patientFileId;
		this.patientId = patientId;
		this.fileName = fileName;
		this.description = description;
		this.fileUrl = fileUrl;
	}

	public int getPatientFileId() {
		return patientFileId;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getFileUrl() {
		return fileUrl;
	}
}
