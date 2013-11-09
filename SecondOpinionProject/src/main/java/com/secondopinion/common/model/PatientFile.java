package com.secondopinion.common.model;


/**
 * Represents a file uploaded by patient.
 * 
 * @author jinsu
 */
public class PatientFile {
	public final int patientId;
	public final String fileName;
	public final String description;
	public final String fileUrl;
	
	public PatientFile(int patientId, String fileName,
			String description, String fileUrl) {
		this.patientId = patientId;
		this.fileName = fileName;
		this.description = description;
		this.fileUrl = fileUrl;
	}
}
