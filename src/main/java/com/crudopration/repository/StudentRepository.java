package com.crudopration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudopration.entity.Student;

public interface StudentRepository extends JpaRepository<Student ,Integer> {

}
