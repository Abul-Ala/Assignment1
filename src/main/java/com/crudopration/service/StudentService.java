package com.crudopration.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crudopration.entity.Student;
import com.crudopration.repository.StudentRepository;

@Component
public class StudentService {

	@Autowired
	StudentRepository stuRepo;

	public void saveStudent(Student student) {
		stuRepo.save(student);
	}
	public Student getStudentById(int id) {
		Student student = stuRepo.findById(id).orElse(new Student());
		return student;

	}

	public ArrayList<Student> getStudents() {
		ArrayList<Student> list = (ArrayList<Student>) stuRepo.findAll();
		return list;

	}
	public void updateStudent(Student student) {
		stuRepo.save(student);

	}

	public void deleteStudentById(int id) {

		stuRepo.deleteById(id);

	}



}
