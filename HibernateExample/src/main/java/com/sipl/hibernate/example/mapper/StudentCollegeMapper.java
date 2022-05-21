package com.sipl.hibernate.example.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.sipl.hibernate.example.dtos.StudentCollegeDto;
import com.sipl.hibernate.example.entities.StudentEntity;

@Mapper(componentModel = "spring")
public interface StudentCollegeMapper {

	StudentCollegeDto mapStudentEntityToStudentCollegeDto(StudentEntity studentEntity);
	
	StudentEntity mapStudentCollegeDtoToStudentEntity(StudentCollegeDto studentCollegeDto);
	
	List<StudentCollegeDto> studentEntityListToStudentCollegeDtoList(List<StudentEntity> studentList);
}
