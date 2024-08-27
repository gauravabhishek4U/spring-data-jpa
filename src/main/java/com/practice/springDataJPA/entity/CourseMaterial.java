package com.practice.springDataJPA.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
@Table(name ="tbl_course_material")
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "courseMaterial_sequence", sequenceName = "courseMaterial_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "courseMaterial_sequence")
    private Long courseMaterialId;
    @Column(nullable = false)
    private String courseMaterialType;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    // Fetch type EAGER will fecth complete details of course material including details of course associated with it.
    // Fetch type LAZY will only fetch details of course materials. It will not fetch details of course with it.
    // We need to annotate the CourseMaterial class with "@ToString(exclude="course")" to use Fetch type as LAZY here.
    @JoinColumn(name = "courseId", referencedColumnName = "courseId")
    private Course course;


}
