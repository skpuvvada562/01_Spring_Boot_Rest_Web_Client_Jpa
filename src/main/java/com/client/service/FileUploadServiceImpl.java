package com.client.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;

@Component
public class FileUploadServiceImpl implements FileUploadService {

	@Autowired
	private AmazonS3 s3Client;
	
	
	@Value("${application.bucket.name}")
	private String bucketName;
	
	@Override
	public String upload(MultipartFile file) {
		String fileName=System.currentTimeMillis()+"-"+file.getOriginalFilename();
		File fileObj=convertMultiPartFileToFile(file);
		s3Client.putObject(bucketName, fileName, fileObj);
		fileObj.delete();
		return "File uploaded successfully=="+file.getOriginalFilename();
	}

	private File convertMultiPartFileToFile(MultipartFile file) {
		File convertedFile=new File(file.getOriginalFilename());
		try(FileOutputStream fos=new FileOutputStream(convertedFile)){
			
			fos.write(file.getBytes());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return convertedFile;
	}

	@Override
	public byte[] downloadFile(String fileName) {
		S3Object s3Obj=s3Client.getObject(new GetObjectRequest(bucketName, fileName));
		S3ObjectInputStream s3Input=s3Obj.getObjectContent();
		try {
			byte[] content=IOUtils.toByteArray(s3Input);
			return content;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String deleteFile(String fileName) {
		
		s3Client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
		return fileName + "File removed successfully";
	}

}
