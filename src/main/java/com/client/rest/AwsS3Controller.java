package com.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.client.service.FileUploadService;

@RestController
@RequestMapping("/file")
public class AwsS3Controller {

	@Autowired
	private FileUploadService fileUploadService;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam MultipartFile file){
		String message=fileUploadService.upload(file);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
	@GetMapping("/download/{fileName}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName){
		byte[] data=fileUploadService.downloadFile(fileName);
		ByteArrayResource resource=new ByteArrayResource(data);
		
		return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
							 
	}
	
	@DeleteMapping("delete/{fileName}")
	public ResponseEntity<String> deleteFile(@PathVariable String fileName){
		
		return new ResponseEntity<String>(fileUploadService.deleteFile(fileName),HttpStatus.OK);
	}
	
}
