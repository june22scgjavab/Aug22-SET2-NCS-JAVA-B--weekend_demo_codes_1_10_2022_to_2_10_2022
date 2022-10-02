package com.infosys.crud.controller;

import com.infosys.crud.exception.StudentException;
import com.infosys.crud.model.StudentDTO;
import com.infosys.crud.service.StudentService;
import com.infosys.crud.service.StudentServiceImpl;

public class StudentController {

	  private StudentService studentService=new StudentServiceImpl();
	
	      public String addStudent(StudentDTO student) throws StudentException {
	    	   String status=studentService.addStudent(student);
	    	    return status;       
	    	        
	       }
	       
}
