package com.crudopration.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crudopration.entity.Student;
import com.crudopration.service.StudentService;

@RestController
public class HomeController {

	@Autowired
	StudentService studentService;

	@GetMapping("/")
	public String index() {
		return "Application is working";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "Student is saved";

	}
	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = studentService.getStudentById(id);
		return student;
	}
	@GetMapping("/getListOfStudents")
	public ArrayList<Student> getListOfStudents() {

		ArrayList<Student> list = studentService.getStudents();
		return list;
	}
	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student) {
		studentService.updateStudent(student);
		return "Student Updated";
	}
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "Student deleted successfully";
	}

}
