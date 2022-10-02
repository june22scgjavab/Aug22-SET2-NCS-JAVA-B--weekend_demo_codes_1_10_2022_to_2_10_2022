package com.infosys.crud.interfc;

import com.infosys.crud.controller.StudentController;
import com.infosys.crud.exception.StudentException;
import com.infosys.crud.model.StudentDTO;

public class Application {
public static void main(String args[])
{
	try
	{
	StudentDTO student=new StudentDTO();
    StudentController studentController=new StudentController();
    //student.setRoll(1000); student.setName("Rajiv"); student.setMarks(90);
	/*
	 * student.setRoll(1); student.setName("Rajiv"); student.setMarks(90);
	 */
   // student.setRoll(1); student.setName("Rajiv123"); student.setMarks(90);
    student.setRoll(1); student.setName("Rajiv"); student.setMarks(900);
    String status=studentController.addStudent(student);
    System.out.println(status);
	}catch(StudentException ex)
	{
		System.out.println(ex.getMessage());
	}
    
   
	/*
	 * student.setRoll(1000); student.setName("Rajiv"); student.setMarks(90);
	 * student.setRoll(1); student.setName("Rajiv123"); student.setMarks(90);
	 * student.setRoll(1); student.setName("Rajiv"); student.setMarks(900);
	 */
    
}
}
