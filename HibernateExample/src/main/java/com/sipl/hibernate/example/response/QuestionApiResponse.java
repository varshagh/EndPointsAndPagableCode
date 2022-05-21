package com.sipl.hibernate.example.response;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.sipl.hibernate.example.dtos.QuestionDto;
import com.sipl.hibernate.example.entities.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionApiResponse {

	private Question question;
	private QuestionDto questionDto;
	private List<QuestionDto> questionDtos;
	private HttpStatus status;
	private String message;
    private boolean error;
}
