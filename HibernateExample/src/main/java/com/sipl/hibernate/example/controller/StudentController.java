package com.sipl.hibernate.example.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sipl.hibernate.example.dtos.StudentDto;
import com.sipl.hibernate.example.response.StudentApiResponse;

@RestController
@RequestMapping("/studentEntity")
@CrossOrigin(origins = "*")
public interface StudentController {

//	@GetMapping("/{studentName}")
//	ResponseEntity<StudentApiResponse> getByStudentName(@PathVariable String studentName);

	@GetMapping("/{id}")
	public ResponseEntity<StudentApiResponse> getStudentById(@PathVariable int id);

	@GetMapping("/roll" + "/{rollNo}")
	public ResponseEntity<StudentApiResponse> getStudentByRollNo(@PathVariable(value = "rollNo") int rollNo);

	@PostMapping("/add")
	ResponseEntity<StudentApiResponse> addStudent(@RequestBody StudentDto studentDto);

	@PutMapping("/update")
	ResponseEntity<StudentApiResponse> updateStudent(@RequestBody StudentDto studentDto);

	@DeleteMapping("/{id}")
	ResponseEntity<StudentApiResponse> deleteById(@PathVariable int id);

	@GetMapping("/getStudentDetails")
	ResponseEntity<StudentApiResponse> getStudentDetails();

	@GetMapping("/getAllPagination")
	ResponseEntity<StudentApiResponse> getAllPagination(@RequestParam Optional<Integer> pageNum,
			@RequestParam Optional<Integer> pageSize);

}
