package com.practice.springDataJPA.repository;

import com.practice.springDataJPA.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void getCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println("List of courses :: "+courseList);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithTwoRecords = PageRequest.of(0,2);
        Pageable secondPageWithThreeRecords = PageRequest.of(1,3);

        List<Course> courses = courseRepository.findAll(firstPageWithTwoRecords).getContent();

        System.out.println("courses = "+courses);

    }

}