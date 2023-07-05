package com.client.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.entity.Student;
import com.client.service.CourseService;
import com.client.service.StudentService;

@RestController
public class StudentCourseController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private CourseService courseService;
	
	@PostMapping(value="/save", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> saveStudentCourse(@RequestBody Student student){
		Student st=studentService.save(student);
		return new ResponseEntity<Student>(st,HttpStatus.CREATED);
	}
}
