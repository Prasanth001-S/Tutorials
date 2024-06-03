package com.daystar.Kirti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.daystar.Kirti.Entity.Student;
import com.daystar.Kirti.model.StudentInfo;
import com.daystar.Kirti.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studService;
	
	
	@GetMapping("/getStudent")
	public ResponseEntity<List<Student>> getMapping(){
		return new ResponseEntity<List<Student>>(studService.getStudents(), HttpStatus.OK);
	}
	
	@PostMapping("/saveStudent")
	public ResponseEntity<String> saveStudentInfo(@RequestBody StudentInfo studentInfo){
		return new ResponseEntity<String>(studService.saveStudent(studentInfo), HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/updateStudentInfo")
	public ResponseEntity<String> updateStudentInfo(@RequestBody StudentInfo studentInfo) {
     return new ResponseEntity<String>(studService.updateExsitingStudent(studentInfo), HttpStatus.ACCEPTED);
	}
	

}
