package com.sipl.hibernate.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sipl.hibernate.example.entities.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question , Integer>{


	@Query("select q from Question q where q.id=?1")
    Optional<Question>  findByQuestionId(int id);
}
