package com.crudopration.Repo;

import com.crudopration.entity.Student;
import com.crudopration.repository.StudentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryTests {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Order(1)
    @Rollback(value = false)

    public void saveStudentTest(){

        Student student = Student.builder().id(6).rollNo(3).name("rashid").build();
        studentRepository.save(student);
        Assertions.assertThat(student.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    public void getStudentTest(){

        Student student = studentRepository.findById(6).get();

        Assertions.assertThat(student.getId()).isEqualTo(6);
    }

    @Test
    @Order(3)
    public void getListOfStudentsTest(){

        List<Student> students = studentRepository.findAll();

        Assertions.assertThat(students.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateStudentTest(){

        Student student = studentRepository.findById(6).get();

        student.setName("imam");

        Student studentUpdated =  studentRepository.save(student);

        Assertions.assertThat(studentUpdated.getName()).isEqualTo("imam");

    }
    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteStudentTest(){

        Student student = studentRepository.findById(6).get();

        studentRepository.delete(student);

        Student student1 = null;

        Optional<Student> optionalStudent = studentRepository.findById(6);

        if(optionalStudent.isPresent()){
            student1 = optionalStudent.get();
        }

        Assertions.assertThat(student1).isNull();
    }

}



