package com.sipl.hibernate.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.sipl.hibernate.example.dtos.QuestionDto;
import com.sipl.hibernate.example.entities.Question;
import com.sipl.hibernate.example.mapper.QuestionMapper;
import com.sipl.hibernate.example.repository.QuestionRepository;
import com.sipl.hibernate.example.response.QuestionApiResponse;
import com.sipl.hibernate.example.service.QuestionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Override
	public QuestionApiResponse add(QuestionDto questionDto) {
		try {
			
		log.info("<<start>>add<<start>>");
		Question question = questionMapper.mapQuestionDtoToQuestion(questionDto);
		Question questionSavedTodb = questionRepository.save(question);
		log.info("Question Saved to Db :" + questionSavedTodb);
		log.info("<<end>>add<<end>>");
		return new QuestionApiResponse(questionSavedTodb, questionMapper.mapQuestionToQuestionDto(questionSavedTodb), null,
				HttpStatus.CREATED, "question added successfully", false);
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Database connectivity error,Name: " + e);
		}
		return new QuestionApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", true);
	}

	@Override
	public QuestionApiResponse getQuestionAnswerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
