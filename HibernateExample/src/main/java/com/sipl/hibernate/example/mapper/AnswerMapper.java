package com.sipl.hibernate.example.mapper;

import org.mapstruct.Mapper;
import com.sipl.hibernate.example.dtos.AnswerDto;
import com.sipl.hibernate.example.entities.Answer;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

	AnswerDto mapAnswerToAnswerDto(Answer answer);
	
	Answer mapAnswerDtoToAnswer(AnswerDto answerDto);
	
}
