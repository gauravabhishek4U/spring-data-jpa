package com.practice.springDataJPA.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_course")
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1, initialValue = 101)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;
    @Column(nullable = false)
    private String title;
    private int credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

}