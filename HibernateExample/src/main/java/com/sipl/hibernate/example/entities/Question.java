package com.sipl.hibernate.example.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="student_question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question_name")
	private String questionName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="answer_fk")
	private List<Answer> answer;
}
