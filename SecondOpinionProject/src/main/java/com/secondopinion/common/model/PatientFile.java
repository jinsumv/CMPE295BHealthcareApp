package com.secondopinion.common.model;

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
}
