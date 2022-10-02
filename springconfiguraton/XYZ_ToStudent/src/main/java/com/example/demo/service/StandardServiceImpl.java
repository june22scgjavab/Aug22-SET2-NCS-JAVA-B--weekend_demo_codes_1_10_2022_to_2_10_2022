package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.XyzException;
import com.example.demo.model.StandardDTO;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.StandardRepository;
import com.example.demo.validator.Validator;

@Service
public class StandardServiceImpl implements StandardService {

	
	@Autowired
	private StandardRepository repo;
	@Override
	public Integer addStandard(StandardDTO standard) throws XyzException {
	
		List<StudentDTO> students=standard.getStudentList();
	  for(StudentDTO student : students)
	  {
		Validator.validate(student);
		
			
		}
	  			return repo.addStandard(standard);
	}

	@Override
	public List<StandardDTO> getStandardDetails(int standard) throws XyzException {
		List<StandardDTO> list=repo.getStandardDetails();
		List<StandardDTO> specificStandard=list.stream().filter(st->st.getStandard()==standard).collect(Collectors.toList());
		return specificStandard;
	}

}
