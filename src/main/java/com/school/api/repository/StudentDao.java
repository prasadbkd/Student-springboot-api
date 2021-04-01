package com.school.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.school.api.model.Student;

@Repository
public interface StudentDao extends CrudRepository<Student, Integer> {

}
