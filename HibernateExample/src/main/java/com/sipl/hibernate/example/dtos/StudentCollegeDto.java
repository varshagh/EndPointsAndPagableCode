package com.sipl.hibernate.example.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCollegeDto {

	private int collegeId;
	private String collegeName;
}
