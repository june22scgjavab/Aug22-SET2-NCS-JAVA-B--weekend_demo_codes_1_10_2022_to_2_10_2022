package com.example.demo1.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo1.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
