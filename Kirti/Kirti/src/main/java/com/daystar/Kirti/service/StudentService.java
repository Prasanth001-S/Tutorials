package com.daystar.Kirti.service;

import java.util.List;

import com.daystar.Kirti.Entity.Student;
import com.daystar.Kirti.model.StudentInfo;

public interface StudentService {

	public List<Student> getStudents();

	public String saveStudent(StudentInfo studentInfo);

	public String updateExsitingStudent(StudentInfo studentInfo);

}
