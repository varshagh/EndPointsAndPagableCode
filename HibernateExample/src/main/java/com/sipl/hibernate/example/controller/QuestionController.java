package com.sipl.hibernate.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sipl.hibernate.example.dtos.QuestionDto;
import com.sipl.hibernate.example.response.QuestionApiResponse;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public interface QuestionController {

	@PostMapping("/add")
	ResponseEntity<QuestionApiResponse> add(@RequestBody QuestionDto questionDto);
	
	@DeleteMapping("/{id}")
	ResponseEntity<QuestionApiResponse> getQuestionAnswerById(@PathVariable int id);
}
