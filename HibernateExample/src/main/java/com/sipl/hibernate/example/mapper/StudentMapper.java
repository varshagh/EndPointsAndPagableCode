package com.sipl.hibernate.example.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.sipl.hibernate.example.dtos.StudentDto;
import com.sipl.hibernate.example.entities.StudentEntity;

@Mapper(componentModel = "spring")
public interface StudentMapper {

	StudentDto mapStudentEntityToStudentDto(StudentEntity studentEntity);

	StudentEntity mapStudentDtoToStudentEntity(StudentDto studentDto);

	List<StudentDto> studentEntityListToStudentDtoList(List<StudentEntity> studentList);

	default Page<StudentDto> mapStudentEntityToStudentDto(Page<StudentEntity> studentFetchedFromDb) {
		return studentFetchedFromDb.map(this::mapStudentEntityToStudentDto);
	}

}
