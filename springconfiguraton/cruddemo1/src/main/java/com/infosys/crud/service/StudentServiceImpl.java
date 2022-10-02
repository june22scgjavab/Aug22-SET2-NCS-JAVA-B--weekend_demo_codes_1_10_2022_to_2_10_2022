package com.infosys.crud.service;

import com.infosys.crud.exception.StudentException;
import com.infosys.crud.model.StudentDTO;
import com.infosys.crud.repository.StudentRepository;
import com.infosys.crud.repository.StudentRepositoryImpl;
import com.infosys.crud.validator.Validator;

public class StudentServiceImpl implements StudentService {
  // Validation and other bsns logic
	StudentRepository studentRepo=new StudentRepositoryImpl();
	public String addStudent(StudentDTO student) throws StudentException {
	boolean isAdded;
	String status="ERROR";
	Validator.validate(student);
	isAdded=studentRepo.addStudent(student);
    if(isAdded) {
    	status="SUCCESS";
    }
	
    return status;
	}
	}
