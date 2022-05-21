package com.sipl.hibernate.example.service;

import org.springframework.stereotype.Service;

import com.sipl.hibernate.example.dtos.QuestionDto;
import com.sipl.hibernate.example.response.QuestionApiResponse;


@Service
public interface QuestionService {
	
	QuestionApiResponse add(QuestionDto questionDto);
	
	QuestionApiResponse getQuestionAnswerById(int id);
}
