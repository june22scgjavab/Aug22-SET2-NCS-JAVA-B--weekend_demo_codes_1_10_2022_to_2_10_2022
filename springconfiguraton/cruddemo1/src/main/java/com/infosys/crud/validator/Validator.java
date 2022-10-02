package com.infosys.crud.validator;

import com.infosys.crud.exception.StudentException;
import com.infosys.crud.model.StudentDTO;

public class Validator {

	public static void validate(StudentDTO student) throws StudentException {
		if(!(validateRoll(student.getRoll()) &&  validateName(student.getName()) && validateMarks(student.getMarks())             ))
		{
			throw new StudentException("Data is incorrect");
		}
		
	}

	private static boolean validateMarks(int marks) {
		boolean isValidMarks=false;
		isValidMarks=(marks>=1 && marks<=100)?true:false;
		return isValidMarks;
	}
  // String name="";
	private static boolean validateName(String name) {
		boolean isValidName=false;
		String pattern="[a-zA-Z]+";
		isValidName=name.matches(pattern);
		return isValidName;
	}

	private static boolean validateRoll(int roll) {
		boolean isValidRoll=false;
		isValidRoll=(roll>=1 && roll<=100)?true:false;
		return isValidRoll;
	}

}
