package com.sipl.hibernate.example.mapper;

import org.mapstruct.Mapper;
import com.sipl.hibernate.example.dtos.QuestionDto;
import com.sipl.hibernate.example.entities.Question;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

	QuestionDto mapQuestionToQuestionDto(Question question);
	
	Question mapQuestionDtoToQuestion(QuestionDto questionDto);
	
}
