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
@Table(name = "student_info")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int id;

	@Column(name = "student_roll_no")
	private int rollNo;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_city")
	private String city;

}
