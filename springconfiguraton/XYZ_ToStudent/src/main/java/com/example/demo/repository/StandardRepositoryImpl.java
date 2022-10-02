package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.exception.XyzException;
import com.example.demo.model.StandardDTO;
import com.example.demo.model.StudentDTO;

@Repository
public class StandardRepositoryImpl implements StandardRepository {

	List<StandardDTO> standards=new ArrayList<>();
	private static int standard=0;
	
	public StandardRepositoryImpl()
	{
		standard++;
		StandardDTO standardDTO=new StandardDTO();
		standardDTO.setStandard(standard);
		StudentDTO student1=new StudentDTO();
		student1.setRoll(1);
		student1.setName("Ramesh");
		StudentDTO student2=new StudentDTO();
		student2.setRoll(2);
		student2.setName("Suresh");
		List<StudentDTO> studentDTO=new ArrayList<>();
		studentDTO.add(student1);
		studentDTO.add(student2);
		standardDTO.setStudentList(studentDTO);
		standards.add(standardDTO);
		
		
	}
	
	
	
	@Override
	public Integer addStandard(StandardDTO standardDTO) throws XyzException {
		standard++;
		standardDTO.setStandard(standard);
		standards.add(standardDTO);
		return standardDTO.getStandard();
	}

	@Override
	public List<StandardDTO> getStandardDetails() throws XyzException {
		// TODO Auto-generated method stub
		return standards;
	}

}
