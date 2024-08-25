package com.practice.springDataJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.springDataJPA.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

    List<Student> findByFirstName(String firstName);

    List<Student> findByGuardianName(String guardianName);
}
