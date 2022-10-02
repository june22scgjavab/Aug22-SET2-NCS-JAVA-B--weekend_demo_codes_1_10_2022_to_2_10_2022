package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.dto.StudentDTO;
import com.example.demo1.exceptions.StudentException;
import com.example.demo1.service.StudentService;

@RestController
@RequestMapping("/students")

public class StudentAPI {

	    @Autowired
	    private StudentService studentService;  
	
// http://localhost:8080/students/addStudent	    
	    @PostMapping("/addstudent")
	    public ResponseEntity<String> addStudent(@RequestBody StudentDTO studentDTO)
	    {
	          try {
				studentService.addStudent(studentDTO);
				
			} catch (StudentException e) {
			
				e.printStackTrace();
			}
	        return new ResponseEntity<>("SUCCESS",HttpStatus.OK);
	    }
	 // http://localhost:8080/students/getStudent/11	    
	    @GetMapping("/getstudent/{roll}")
	    public ResponseEntity<Object> getStudent(@PathVariable int roll)
	    {
	    	StudentDTO studentDTO=null;
	    	try {
				studentDTO=studentService.getStudent(roll);
			} catch (StudentException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
	       return new ResponseEntity<>(studentDTO,HttpStatus.OK);
	    }
	    
	 // http://localhost:8080/students/updateStudent/11	   
	    @PutMapping(value = "/updatestudent/{roll}")
		public ResponseEntity<String> updateStudent(@PathVariable Integer roll, @RequestBody StudentDTO student)
	
				throws StudentException {
			studentService.updateStudent(roll, student.getMarks());
			String successMessage = "Updated";
			return new ResponseEntity<>(successMessage, HttpStatus.OK);
		}
}
