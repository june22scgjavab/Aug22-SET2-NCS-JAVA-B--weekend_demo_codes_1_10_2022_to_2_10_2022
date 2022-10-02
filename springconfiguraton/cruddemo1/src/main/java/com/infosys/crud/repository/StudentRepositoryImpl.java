package com.infosys.crud.repository;

import java.util.ArrayList;
import java.util.List;

import com.infosys.crud.model.StudentDTO;

public class StudentRepositoryImpl implements StudentRepository {

	private List<StudentDTO> studentList=new ArrayList<>();
	public boolean addStudent(StudentDTO student) {
		
		boolean isAdded=studentList.add(student);
		return isAdded;
	    	  
	}

}
