package com.schoolapp.afterschoolapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;
    private Long studentId;
    private String enrollmentDate;



    @OneToMany(targetEntity = Attendance.class, cascade = { CascadeType.ALL })
    private List<Student> students;

    public Enrollment(Long studentId, String enrollmentDate ) {
        this.studentId = studentId;
       this.enrollmentDate=enrollmentDate;
    }

}

