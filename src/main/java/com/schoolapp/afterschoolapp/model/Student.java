package com.schoolapp.afterschoolapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@ToString
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(name = "firstName")
    private String firstName

;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "motherName")
    private String motherName;
    @Column(name = "fatherName")
    private String fatherName;
    @Column(name = "m_contactNo")
    private String m_contactNo;
    @Column(name = "f_contactNo")
    private String f_contactNo;
    @Column(name = "DOB")
    private LocalDate DOB;
    @Column(name = "grade")
    private String grade;
    @Column(name="address")
    private String address;
    @Column(name = "medicalconcerns")
    private String medicalConcerns;
    @Column(name = "gender")
    private String gender;

    @OneToMany(targetEntity = Attendance.class, cascade = { CascadeType.ALL })
    private List<Attendance> attendance;

    public Student(Long studentId, String firstName, String lastName,String email, String motherName, String mContactNo,String fatherName,String fContactNo ,LocalDate DOB,String grade,String address,String medicalConcerns,String gender) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.motherName=motherName;
        this.m_contactNo=mContactNo;
        this.f_contactNo=fContactNo;
        this.fatherName=fatherName;
        this.DOB=DOB;
        this.grade=grade;
        this.address=address;
        this.medicalConcerns=medicalConcerns;
        this.gender=gender;


    }
    public Student( String firstName, String lastName,String email, String motherName, String mContactNo,String fatherName,String fContactNo ,LocalDate DOB,String grade,String address,String gender,String medicalConcerns) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email=email;
        this.motherName=motherName;
        this.m_contactNo=mContactNo;
        this.f_contactNo=fContactNo;
        this.fatherName=fatherName;
        this.DOB=DOB;
        this.grade=grade;
        this.address=address;
        this.gender=gender;
        this.medicalConcerns=medicalConcerns;


    }

}