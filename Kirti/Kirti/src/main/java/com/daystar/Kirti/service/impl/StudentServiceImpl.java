package com.daystar.Kirti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daystar.Kirti.Entity.Student;
import com.daystar.Kirti.Repository.StudentRepo;
import com.daystar.Kirti.model.StudentInfo;
import com.daystar.Kirti.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;

	@Override
	public List<Student> getStudents() {

		return studentRepo.findAll();
	}

	@Override
	public String saveStudent(StudentInfo studentInfo) {

		Student student = new Student();

		student.setName(studentInfo.getName());
		student.setAddress(studentInfo.getAddress());
		student.setRollNo(studentInfo.getRollNo());

		if (studentRepo.save(student) != null) {
			return "Student Info saved Successfully";
		}

		return "There is Some Error. Please check you code";
	}

	@Override
	public String updateExsitingStudent(StudentInfo studentInfo) {
		Student student = studentRepo.findByName(studentInfo.getName());

		if (student == null) {
			return "please check you name";
		}

		student.setName(studentInfo.getName());
		student.setAddress(studentInfo.getAddress());
		student.setRollNo(studentInfo.getRollNo());

		if (studentRepo.save(student) != null) {
			return "Updation Completed";
		}

		return "Operation Failled";

	}

}
