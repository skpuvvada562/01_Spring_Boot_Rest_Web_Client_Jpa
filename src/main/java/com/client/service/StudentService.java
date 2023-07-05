package com.client.service;

import org.springframework.stereotype.Service;

import com.client.entity.Student;

@Service
public interface StudentService {

	public Student save(Student student);
}
