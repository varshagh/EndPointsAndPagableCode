package com.sipl.hibernate.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
	private int id;
	private int rollNo;
	private String studentName;
	private String city;

}
