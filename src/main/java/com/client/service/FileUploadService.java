package com.client.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileUploadService {

	public String upload(MultipartFile file);
	
	public byte[] downloadFile(String fileName);
	
	public String deleteFile(String fileName);
}
