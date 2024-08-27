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

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = new Guardian();
        guardian.setName("Elda Shanks");
        guardian.setEmail("eldashanks@marine.com");
        guardian.setMobile("023 9635 1234");

        Student student = Student.builder()
                .firstName("Koby")
                .lastName("Shanks")
                .emailId("kobyshanks@marine.com")
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

    @Test
    public void getStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Koby");
        for (Student student : students) {
            System.out.println(student);
        }

    }

    @Test
    public void getStudentByGuardianName(){
        List<Student> studentList = studentRepository.findByGuardianName("Alves Rizaro");
        System.out.println(studentList);
    }

    @Test
    public void getStudentByFirstNameAndLastName(){
        Student student = studentRepository.findByFirstNameAndLastName("Roronova", "Zoro");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("roronovazoro@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentFirstNameByLastName(){
        String firstName = studentRepository.getStudentFirstNameByLastName("Targereyan");
        System.out.println(firstName);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        List<Student> studentList = studentRepository.getStudentByEmailAddressNative("@gmail.com");
        System.out.println("Details of student based on email address : "+studentList);
    }

    @Test
    public void getStudentByEmailAddressNativeParamQuery(){
        List<Student> studentList = studentRepository.getStudentByEmailAddressNativeParamQuery("kobyshanks@marine.com");
        System.out.println("Details of student based on email address : "+studentList);
    }

    @Test
    public void updateStudentFirstNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Darcy", "kobyshanks@marine.com");
    }



}
