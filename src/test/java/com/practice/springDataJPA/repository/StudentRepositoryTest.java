package com.practice.springDataJPA.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.springDataJPA.entity.Guardian;
import com.practice.springDataJPA.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    // test to save a student to the database
    // @Test
    // public void saveStudent() {
    //     Student student = Student.builder()
    //             .firstName("Koby")
    //             .lastName("Shant")
    //             .emailId("kobyshant@marine.com")
    //             // .guardianName("Lucy Shant")
    //             // .guardianEmail("lucyshant@marine.com")
    //             // .guardianMobile("082 111 2343")
    //             .build();

    //     studentRepository.save(student);
    // }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = new Guardian();
        guardian.setName("Alves Rizaro");
        guardian.setEmail("rizaroalves@gmail.com");
        guardian.setMobile("082 764 7363");

        Student student = Student.builder()
                .firstName("Roronova")
                .lastName("Zoro")
                .emailId("roronovazoro@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            System.out.println(student);
        }

    }

//    @Test
//    public void getStudentByFirstName(String firstName) {
//
//        List<Student> students = studentRepository.findByFirstName("Koby");
//        for (Student student : students) {
//            System.out.println(student);
//        }
//
//    }

    @Test
    public void getStudentByGuardianName(String guardianName){
        List<Student> studentList = studentRepository.findByGuardianName("Alves Rizaro");
        System.out.println(studentList);
    }
}
