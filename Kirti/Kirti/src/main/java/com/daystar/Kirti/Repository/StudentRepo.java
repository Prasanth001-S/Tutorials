package com.daystar.Kirti.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daystar.Kirti.Entity.Student;


@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{  
	
	public Student findByrollNo(String rollNo);
	
	public Student findByName(String name);

}
