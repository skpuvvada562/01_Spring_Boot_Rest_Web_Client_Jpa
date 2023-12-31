package com.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.client.entity.Student;
import com.client.repository.CourseRepository;
import com.client.repository.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	
	@Override
	public Student save(Student student) {
		return studentRepo.save(student);
	}


	@Override
	public List<Student> findAllStudents() {
		return studentRepo.findAll();
	}

}
