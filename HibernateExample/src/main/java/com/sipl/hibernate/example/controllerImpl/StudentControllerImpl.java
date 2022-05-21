package com.sipl.hibernate.example.controllerImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sipl.hibernate.example.controller.StudentController;
import com.sipl.hibernate.example.dtos.StudentDto;
import com.sipl.hibernate.example.response.StudentApiResponse;
import com.sipl.hibernate.example.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentControllerImpl implements StudentController {

	@Autowired
	private StudentService studentService;

	@Override
	public ResponseEntity<StudentApiResponse> getStudentByRollNo(int rollNo) {
		log.info("getStudentByRollNo endpoint called");
		return new ResponseEntity<>(studentService.getStudentByRollNo(rollNo), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentApiResponse> deleteById(int id) {
		log.info("deleteById endpoint called");
		return new ResponseEntity<>(studentService.deleteById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentApiResponse> addStudent(StudentDto studentDto) {
		log.info("addstudent endpoint called");
		return new ResponseEntity<>(studentService.addStudent(studentDto), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentApiResponse> updateStudent(StudentDto studentDto) {
		log.info("updatestudent endpoint called");
		return new ResponseEntity<>(studentService.updateStudent(studentDto), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentApiResponse> getStudentDetails() {
		log.info("getStudentDetails endpoint called");
		return new ResponseEntity<>(studentService.getStudentDetails(), HttpStatus.OK);

	}

	@Override
	public ResponseEntity<StudentApiResponse> getStudentById(int id) {
		log.info("getStudentById endpoint called");
		return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<StudentApiResponse> getAllPagination(Optional<Integer> pageNum, Optional<Integer> pageSize) {
		log.info("<<start>>getAllPagination endpoint called <<start>>");
		ResponseEntity<StudentApiResponse> responseEntity = new ResponseEntity<>(
				studentService.getAllPagination(pageNum, pageSize), HttpStatus.OK);
		log.info("<<end>> getAllPagination <<end>>");
		return responseEntity;
	}

}
