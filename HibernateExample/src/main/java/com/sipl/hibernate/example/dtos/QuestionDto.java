package com.sipl.hibernate.example.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

	private int questionId;
	private String questionName;
	private List<AnswerDto> answer;
}
