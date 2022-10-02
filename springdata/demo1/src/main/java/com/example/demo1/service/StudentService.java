package com.example.demo1.service;

import com.example.demo1.dto.StudentDTO;
import com.example.demo1.exceptions.StudentException;

public interface StudentService {
 void addStudent(StudentDTO studentDTO) throws StudentException;
 StudentDTO getStudent(Integer roll) throws StudentException;
void updateStudent(Integer roll, Integer marks) throws StudentException;    
	   
   
}
