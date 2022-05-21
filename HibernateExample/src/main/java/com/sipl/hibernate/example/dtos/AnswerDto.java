package com.sipl.hibernate.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

	private int answerId;
	private String answerName;

}
