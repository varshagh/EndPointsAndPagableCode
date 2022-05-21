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


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student_college_info")
public class StudentCollege {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="college_id")
	private int collegeId;
	
	@Column(name="college_name")
	private String collegeName;
	
	

}
