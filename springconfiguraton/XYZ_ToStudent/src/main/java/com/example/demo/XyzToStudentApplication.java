package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.example.demo.exception.XyzException;
import com.example.demo.model.StandardDTO;
import com.example.demo.model.StudentDTO;
import com.example.demo.service.StandardService;


@SpringBootApplication
public class XyzToStudentApplication implements CommandLineRunner{

	private static final Log LOGGER = LogFactory.getLog(XyzToStudentApplication.class);

	@Autowired
	private StandardService service;
	
	@Autowired
	private Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(XyzToStudentApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		addStandard();
		//getStandardDetails();
	}
	
	private void getStandardDetails() {
		
		
	}
	void addStandard()
	{
		try {
	StandardDTO standardDTO=new StandardDTO();
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
	service.addStandard(standardDTO);
	LOGGER.info(environment.getProperty("SUCCESS"));
	} catch (XyzException exception) {
		LOGGER.error(environment.getProperty(exception.getMessage()));
		//e.printStackTrace();
	}
	}
	
	
	}
