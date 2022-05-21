package com.sipl.hibernate.example.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sipl.hibernate.example.dtos.StudentDto;
import com.sipl.hibernate.example.entities.StudentEntity;
import com.sipl.hibernate.example.mapper.StudentMapper;
import com.sipl.hibernate.example.repository.StudentRepository;
import com.sipl.hibernate.example.response.StudentApiResponse;
import com.sipl.hibernate.example.service.StudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private StudentMapper studentMapper;

	@Override
	public StudentApiResponse getStudentByRollNo(int rollNo) {
		final Optional<StudentEntity> studentFetchedFromDb = studentRepository.findStudentByRollNo(rollNo);
		if (studentFetchedFromDb.isPresent()) {
			final StudentDto studentFromDb = studentMapper.mapStudentEntityToStudentDto(studentFetchedFromDb.get());
			System.out.println("Sending studentFetchedFromDb response: " + studentFromDb);
			return new StudentApiResponse(studentFromDb, null, null, HttpStatus.OK, "Student RollNo fetched" + rollNo,
					false);
		} else {
			return new StudentApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Student RollNo doesn't exists",
					true);
		}
	}

	@Override
	public StudentApiResponse deleteById(int id) {

		log.info("<<start>>In StudentEntity deleteById method<<start>>");
		try {
			log.debug("In Student deleteById method ID: " + id);
			final Optional<StudentEntity> studentEntityIdFetchedFromDb = studentRepository.findById(id);
			log.debug("Student deleteById response: " + studentEntityIdFetchedFromDb);
			if (studentEntityIdFetchedFromDb.isPresent()) {
				StudentEntity studentEntityFromDb = studentEntityIdFetchedFromDb.get();
				studentRepository.deleteById(id);
				log.debug("Deleted Student with id: " + id + ", active set to false");
				final StudentDto studentDtoToSend = studentMapper.mapStudentEntityToStudentDto(studentEntityFromDb);
				log.debug("Sending updated studentEntityIdFetchedFromDb response: " + studentDtoToSend);
				return new StudentApiResponse(studentDtoToSend, null, null, HttpStatus.OK,
						"Id " + studentEntityFromDb.getId() + " deleted successfully", false);
			} else {
				log.info("<<end>>In Student deleteById method<<end>>");
				return new StudentApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Id doesn't exists", true);
			}

		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("StudentEntity deleteById JDBCConnectionException:", e);
		} catch (final Exception e) {
			log.error("StudentEntity deleteById Exception: ", e);
		}
		return new StudentApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", true);
	}

	@Override
	public StudentApiResponse addStudent(StudentDto studentDto) {
		try {
			log.info("<<start>>addStudent<<start>>");
			StudentEntity studentEntity = studentMapper.mapStudentDtoToStudentEntity(studentDto);
			StudentEntity studentEntitySavedTodb = studentRepository.save(studentEntity);
			log.info("Student Saved to Db :" + studentEntitySavedTodb);
			log.info("<<end>>addStudentEntity<<end>>");
			return new StudentApiResponse(studentMapper.mapStudentEntityToStudentDto(studentEntitySavedTodb), null,
					null, HttpStatus.CREATED, "Student added successfully", false);
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Database connectivity error,Name: " + e);
		}
		return new StudentApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", true);
	}

	@Override
	public StudentApiResponse updateStudent(StudentDto studentDto) {
		log.info("<<start>>updateStudent<<start>>");
		try {

			final Optional<StudentEntity> studentEntityFromDb = studentRepository
					.findStudentByRollNo(studentDto.getRollNo());
			log.debug("studentEntityFromDb:", studentEntityFromDb);
			if (studentEntityFromDb.isPresent()) {
				StudentEntity studentEntityToBeUpdated = studentEntityFromDb.get();
				studentEntityToBeUpdated.setStudentName(studentDto.getStudentName());
				studentEntityToBeUpdated.setCity(studentDto.getCity());
				studentEntityToBeUpdated.setRollNo(studentDto.getRollNo());
				StudentEntity updatedStudentEntity = studentRepository.save(studentEntityToBeUpdated);
				return new StudentApiResponse(studentMapper.mapStudentEntityToStudentDto(updatedStudentEntity), null,
						null, HttpStatus.OK, "Student Details Updated successfully", false);
			}
			return new StudentApiResponse(null, null, null, HttpStatus.NOT_FOUND,
					"Please reload application and try again later.", true);
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("Database connectivity error,Name: " + e);
			return new StudentApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", true);
		}
	}

	@Override
	public StudentApiResponse getStudentDetails() {
		try {
			log.info("<<start>> In getStudentDetails method <<start>>");
			final List<StudentEntity> studentEntityList = (List<StudentEntity>) studentRepository.findAll();
			if (null != studentEntityList && !studentEntityList.isEmpty()) {
				List<StudentDto> studentDtoList = studentMapper.studentEntityListToStudentDtoList(studentEntityList);
				return new StudentApiResponse(null, studentDtoList, null, HttpStatus.OK, "studentEntity list found",
						false);
			} else {
				log.info("<<end>> In getStudentDetails method <<end>>");
				return new StudentApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Student list Not found", false);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("database connectivity error" + e);
		}
		return new StudentApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", true);
	}

	@Override
	public StudentApiResponse getStudentById(int id) {
		final Optional<StudentEntity> studentFetchedFromDb = studentRepository.findStudentById(id);
		if (studentFetchedFromDb.isPresent()) {
			final StudentDto studentFromDb = studentMapper.mapStudentEntityToStudentDto(studentFetchedFromDb.get());
			System.out.println("Sending studentFetchedFromDb response: " + studentFromDb);
			return new StudentApiResponse(studentFromDb, null, null, HttpStatus.OK, "Student RollNo fetched" + id,
					false);
		} else {
			return new StudentApiResponse(null, null, null, HttpStatus.NOT_FOUND, "Student RollNo doesn't exists",
					true);
		}
	}

	@Override
	public StudentApiResponse getAllPagination(Optional<Integer> page, Optional<Integer> size) {
		try {
			log.info("<<start>>In getAllPagination method <<start>>");
			final Page<StudentEntity> studentEntity = studentRepository
					.findAllpagination(PageRequest.of(page.orElse(0), size.orElse(5)));
			final Page<StudentDto> studentDtoPage = studentMapper.mapStudentEntityToStudentDto(studentEntity);
			if (null != studentDtoPage) {
				return new StudentApiResponse(null, null, studentDtoPage, HttpStatus.OK, "Student list found", false);
			} else {
				return new StudentApiResponse(null, null, studentDtoPage, HttpStatus.NOT_FOUND,
						"Student list Not found", false);
			}
		} catch (final org.hibernate.exception.JDBCConnectionException e) {
			log.error("database connectivity error", e);
			return new StudentApiResponse(null, null, null, HttpStatus.INTERNAL_SERVER_ERROR, "Server Error", true);
		}
	}

}
