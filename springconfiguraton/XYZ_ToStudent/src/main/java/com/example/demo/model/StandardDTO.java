package com.example.demo.model;

import java.util.List;

public class StandardDTO {
private int standard;

public int getStandard() {
	return standard;
}

public void setStandard(int standard) {
	this.standard = standard;
}

private List<StudentDTO> studentList;

public List<StudentDTO> getStudentList() {
	return studentList;
}

public void setStudentList(List<StudentDTO> studentList) {
	this.studentList = studentList;
}

}
