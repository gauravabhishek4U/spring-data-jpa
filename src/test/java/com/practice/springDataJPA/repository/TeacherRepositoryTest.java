package com.practice.springDataJPA.repository;

import com.practice.springDataJPA.entity.Course;
import com.practice.springDataJPA.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseCourtPolitics = Course.builder()
                .title("Court Affairs")
                .credit(8)
                .build();

        Course courseWarPolitics = Course.builder()
                .title("Battle patterns")
                .credit(8)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Otto")
                .lastName("Hightower")
                .courses(List.of(courseCourtPolitics,courseWarPolitics))
                .build();

                teacherRepository.save(teacher);
    }

}
