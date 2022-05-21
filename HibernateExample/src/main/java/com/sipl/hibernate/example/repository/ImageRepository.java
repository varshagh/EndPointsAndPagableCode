package com.sipl.hibernate.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sipl.hibernate.example.entities.Images;

@Repository
public interface ImageRepository extends CrudRepository<Images , Integer> {

}
