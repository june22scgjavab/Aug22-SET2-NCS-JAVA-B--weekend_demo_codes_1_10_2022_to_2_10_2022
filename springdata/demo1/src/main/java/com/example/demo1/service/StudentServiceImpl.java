package com.example.demo1.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.dto.StudentDTO;
import com.example.demo1.entity.Student;
import com.example.demo1.exceptions.StudentException;
import com.example.demo1.repository.StudentRepository;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public void addStudent(StudentDTO studentDTO) throws StudentException {
	   Student student=new Student();
	   student.setRoll(studentDTO.getRoll());
	   student.setName(studentDTO.getName());
	   student.setMarks(studentDTO.getMarks());
	   studentRepository.save(student);

	}

	@Override
	public StudentDTO getStudent(Integer roll) throws StudentException {
	//Student student=studentRepository.findById(roll).get();
		
	Optional<Student> student=studentRepository.findById(roll);
	Student st=student.orElseThrow(()->new StudentException("Not found"));
	StudentDTO studentDTO=new StudentDTO();
	studentDTO.setRoll(st.getRoll());
	studentDTO.setName(st.getName());
	studentDTO.setMarks(st.getMarks());
	return studentDTO;
	
	}
	@Override
	public void updateStudent(Integer roll, Integer marks) throws StudentException {
		Optional<Student> optional = studentRepository.findById(roll);
		Student student = optional.orElseThrow(() -> new StudentException("Student not found"));
		student.setMarks(marks);
	}
	
	

}
