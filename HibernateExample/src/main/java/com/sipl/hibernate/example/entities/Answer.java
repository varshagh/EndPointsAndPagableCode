package com.sipl.hibernate.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student_answer")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int answerId;
	
	@Column(name="answer_name")
	private String answerName;
		
	
}
