package com.practice.springDataJPA.repository;

import com.practice.springDataJPA.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println("List of courses :: "+courseList);
    }

}