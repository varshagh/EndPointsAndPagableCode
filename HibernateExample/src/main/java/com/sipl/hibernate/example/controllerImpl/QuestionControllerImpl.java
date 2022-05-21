package com.sipl.hibernate.example.controllerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.sipl.hibernate.example.controller.QuestionController;
import com.sipl.hibernate.example.dtos.QuestionDto;
import com.sipl.hibernate.example.response.QuestionApiResponse;
import com.sipl.hibernate.example.service.QuestionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QuestionControllerImpl implements QuestionController{
	
	@Autowired
	private QuestionService questionService;
	
	
	
	@Override
	public ResponseEntity<QuestionApiResponse> add(QuestionDto questionDto) {
	log.info("add endpoint called");
	return new ResponseEntity<>(questionService.add(questionDto), HttpStatus.OK);
}



	@Override
	public ResponseEntity<QuestionApiResponse> getQuestionAnswerById(int id) {
		log.info("getQuestionAnswerById endpoint called");
		return new ResponseEntity<>(questionService.getQuestionAnswerById(id), HttpStatus.OK);
	}

	
}
