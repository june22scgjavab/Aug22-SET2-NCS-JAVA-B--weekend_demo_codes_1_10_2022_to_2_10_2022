package com.example.demo.validator;

import com.example.demo.exception.XyzException;
import com.example.demo.model.StudentDTO;

public class Validator {

	
	public static void validate(StudentDTO studentDTO) throws XyzException
	{
		if(!validateStudentRoll(studentDTO.getRoll()))
		{
			throw new XyzException("Service.idlength");
		}
		
	}

    public static boolean validateStudentRoll(int roll)
    {
    	boolean valid=false;
    	if(roll>=100000 && roll<=999999)
        valid=true;
    	return valid;
    }
    


}
