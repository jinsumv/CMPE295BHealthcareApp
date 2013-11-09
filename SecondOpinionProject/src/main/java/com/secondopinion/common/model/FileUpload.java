package com.secondopinion.common.model;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	public final MultipartFile file;
	public String fileDescription;
	public String fileName;
	
	public FileUpload(MultipartFile file, String fileDescription) {
		this.file = file;
		this.fileDescription = fileDescription;
		fileName = file.getOriginalFilename();
	}
}
