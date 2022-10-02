package com.infosys.demo.service;

import java.util.List;

import com.infosys.demo.dto.StudentDTO;
import com.infosys.demo.exception.InvalidStudentException;

public interface StudentService {
   void addStudent(StudentDTO studentDTO) throws InvalidStudentException;
   StudentDTO searchStudent(int roll)throws InvalidStudentException;
   List<StudentDTO> displayAllStudents()throws InvalidStudentException;
   void updateStudent(int roll,int marks)throws InvalidStudentException;
   void deleteStudent(int roll) throws InvalidStudentException;
    StudentDTO findStudentByName(String name);
   
}
