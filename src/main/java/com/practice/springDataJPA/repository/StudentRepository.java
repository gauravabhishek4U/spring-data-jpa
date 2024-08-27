package com.practice.springDataJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.practice.springDataJPA.entity.Student;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{

    // Custom derived methods
    List<Student> findByFirstName(String firstName);

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    //Query creation using JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // Query Creation using JPQL
    @Query("select s.firstName from Student s where s.lastName = ?1")
    String getStudentFirstNameByLastName(String lastName);

    //native queries
    @Query(value = "select * from tbl_student s where s.email_address LIKE %?1", nativeQuery = true)
    List<Student> getStudentByEmailAddressNative(String emailId);

    //native param queries
    @Query(value = "select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
    List<Student> getStudentByEmailAddressNativeParamQuery(@Param("emailId") String emailId);

    @Modifying // Queries with Modifying annotation can only return void or int
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address= ?2", nativeQuery = true)
    void updateStudentNameByEmailId(String firstName, String EmailId);

}
