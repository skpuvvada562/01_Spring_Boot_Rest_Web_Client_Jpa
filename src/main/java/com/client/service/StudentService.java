package com.client.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.client.entity.Student;

@Service
public interface StudentService {

	public Student save(Student student);
	
	public List<Student> findAllStudents();
}
