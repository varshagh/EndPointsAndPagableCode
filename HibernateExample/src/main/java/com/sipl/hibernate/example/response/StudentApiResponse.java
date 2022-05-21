package com.sipl.hibernate.example.response;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import com.sipl.hibernate.example.dtos.StudentDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentApiResponse {
	private StudentDto studentDto;
	private List<StudentDto> studentDtos;
	private Page<StudentDto> studentDtoPage;
	private HttpStatus status;
	private String message;
	private boolean error;
}
