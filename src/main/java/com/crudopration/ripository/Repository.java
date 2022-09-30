package com.crudopration.ripository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudopration.entity.Student;

public interface Repository extends JpaRepository<Student ,Integer> {

}
