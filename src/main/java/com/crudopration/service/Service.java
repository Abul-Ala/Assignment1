package com.crudopration.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crudopration.entity.Student;
import com.crudopration.ripository.Repository;

@Component
public class Service {

	@Autowired
	Repository stuRepo;

	public void addStudent(Student student) {

		stuRepo.save(student);
	}

	public ArrayList<Student> getStudent() {
		ArrayList<Student> list = (ArrayList<Student>) stuRepo.findAll();
		return list;

	}

	public void updateStudent(Student student) {
		stuRepo.save(student);

	}

	public void deleteStudent(Student student) {
		stuRepo.delete(student);

	}

	public void deleteStudentById(int id) {

		stuRepo.deleteById(id);

	}

	public Student getStudentById(int id) {
		Student student = stuRepo.findById(id).orElse(new Student());
		return student;

	}

}
