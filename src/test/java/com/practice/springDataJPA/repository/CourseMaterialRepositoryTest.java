package com.practice.springDataJPA.repository;

import com.practice.springDataJPA.entity.Course;
import com.practice.springDataJPA.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                        .title("Java Core")
                .credit(7)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseMaterialType("Notes")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getAllCourseMaterial(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("List of course materials:: "+courseMaterialList);

    }




}
