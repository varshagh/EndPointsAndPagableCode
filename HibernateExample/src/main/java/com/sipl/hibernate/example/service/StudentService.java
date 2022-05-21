package com.sipl.hibernate.example.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sipl.hibernate.example.dtos.StudentDto;
import com.sipl.hibernate.example.response.StudentApiResponse;

@Service
public interface StudentService {

	StudentApiResponse getStudentById(int id);

	StudentApiResponse getStudentByRollNo(int rollNo);

	StudentApiResponse addStudent(StudentDto studentDto);

	StudentApiResponse updateStudent(StudentDto studentDto);

	StudentApiResponse deleteById(int id);

	StudentApiResponse getStudentDetails();

	StudentApiResponse getAllPagination(Optional<Integer> page, Optional<Integer> size);

}
