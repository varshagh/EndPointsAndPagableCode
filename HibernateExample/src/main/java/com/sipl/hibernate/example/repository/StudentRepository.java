package com.sipl.hibernate.example.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sipl.hibernate.example.entities.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

	Optional<StudentEntity> findStudentByRollNo(int rollNo);

	Optional<StudentEntity> findById(int id);

	Optional<StudentEntity> findStudentById(int id);

	@Query("select s from StudentEntity s order by s.id desc")
	Page<StudentEntity> findAllpagination(Pageable page);

}
