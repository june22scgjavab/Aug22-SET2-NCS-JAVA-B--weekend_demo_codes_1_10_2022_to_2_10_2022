package com.infosys.crud.service;

import com.infosys.crud.exception.StudentException;
import com.infosys.crud.model.StudentDTO;

public interface StudentService {

	String addStudent(StudentDTO student) throws StudentException;

}
