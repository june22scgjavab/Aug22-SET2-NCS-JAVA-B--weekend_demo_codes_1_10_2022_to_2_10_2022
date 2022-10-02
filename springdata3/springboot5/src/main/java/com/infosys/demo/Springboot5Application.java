package com.infosys.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.infosys.demo.dto.StudentDTO;
import com.infosys.demo.exception.InvalidStudentException;
import com.infosys.demo.service.StudentService;

@SpringBootApplication
public class Springboot5Application implements CommandLineRunner{

	@Autowired
	private StudentService studentService;
	 
	@Autowired
	private Environment env;
	
	public static void main(String[] args) {
		SpringApplication.run(Springboot5Application.class, args);
	   
		 		   		  
	 
	
	}


	@Override
	public void run(String... args) throws Exception {
		/*
		 * Student student=new Student(); student.setRoll(15);
		 * student.setName("Ramesh"); student.setMarks(100);
		 * studentRepository.save(student);
		 */
		
		/*
		 * Iterable<Student> students = studentRepository.findAll();
		 * students.forEach(stu->System.out.println(stu)); Student student3 =
		 * studentRepository.findById(1).get(); System.out.println(student3);
		 */
		  /* studentAdd();*/
		  // studentUpdate(); 
		  /* deleteStudent(); */
		     studentByName();
	}
	
	
	 private void studentByName() {
		String name="Ramesh";
		System.out.println(studentService.findStudentByName(name));
		
	}


	private void deleteStudent() {
		try {
			studentService.deleteStudent(1);
			System.out.println(env.getProperty("Interface.RECORD_DELETED"));
		} catch (InvalidStudentException e) {
			System.out.println(env.getProperty(e.getMessage()));
		}
		
	}


	void studentAdd() {
		   StudentDTO studentDTO=new StudentDTO();
		   studentDTO.setRoll(1);
		   studentDTO.setName("Ram");
		   studentDTO.setMarks(100);
		   try {
			studentService.addStudent(studentDTO);
			System.out.print(env.getProperty("Interface.RECORD_ADDED"));
		} catch (InvalidStudentException e) {
		System.out.println(env.getProperty(e.getMessage()));
		}
		
	 }

     void studentUpdate() {
    	    int roll=10;
    	    int marks=190;
    	    try {
				studentService.updateStudent(roll, marks);
				System.out.println(env.getProperty("Interface.RECORD_UPDATED"));
			} catch (InvalidStudentException e) {
				System.out.println(env.getProperty(e.getMessage()));
			}
     }

}




