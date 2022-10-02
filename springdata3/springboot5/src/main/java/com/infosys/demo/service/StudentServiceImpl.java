package com.infosys.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.demo.dto.StudentDTO;
import com.infosys.demo.entity.Student;
import com.infosys.demo.exception.InvalidStudentException;
import com.infosys.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void addStudent(StudentDTO studentDTO) throws InvalidStudentException {
		Optional<Student> optional = studentRepository.findById(studentDTO.getRoll());
		if (optional.isPresent())
	throw new InvalidStudentException("Service.STUDENT_FOUND");
		Student student = new Student();
		student.setRoll(studentDTO.getRoll());
		student.setName(studentDTO.getName());
		student.setMarks(studentDTO.getMarks());
		studentRepository.save(student);

	}

	@Override
	public StudentDTO searchStudent(int roll) throws InvalidStudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StudentDTO> displayAllStudents() throws InvalidStudentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(int roll, int marks) throws InvalidStudentException {
		Optional<Student> optional = studentRepository.findById(roll);
		Student student = optional.orElseThrow(() -> new InvalidStudentException("Service.STUDENT_NOT_FOUND"));
		student.setMarks(marks);
		
	}

	@Override
	public void deleteStudent(int roll) throws InvalidStudentException {
		Optional<Student> optional = studentRepository.findById(roll);
		Student student = optional.orElseThrow(() -> new InvalidStudentException("Service.STUDENT_NOT_FOUND"));
		studentRepository.deleteById(roll);
	}
	@Override
	public StudentDTO findStudentByName(String name) {
	   Student st=studentRepository.findByName(name);	
	   StudentDTO studentDTO=new StudentDTO();
	   studentDTO.setRoll(st.getRoll());
	   studentDTO.setName(st.getName());
	   studentDTO.setMarks(st.getMarks());
	   return studentDTO;
	}
	}
