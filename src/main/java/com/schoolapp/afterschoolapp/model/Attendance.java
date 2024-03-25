package com.schoolapp.afterschoolapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    @Column(name="studentId")
    private Long studentId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "timeIn")
    private LocalDateTime timeIn;
    @Column(name = "timeOut")
    private LocalDateTime timeOut;
    @Column(name = "status")
    private String status;

    /*@OneToMany(targetEntity = Attendance.class, cascade = { CascadeType.ALL })
    private List<Attendance> attendance;*/


    public Attendance(Long studentId,String firstName,LocalDateTime timeIn, LocalDateTime timeOut, LocalDate date,String status) {
        this.date=date;
        this.firstName=firstName;
        this.studentId=studentId;
        this.timeIn=timeIn;
        this.timeOut=timeOut;
        this.status=status;
    }
    public Attendance(Long studentId,String firstName, LocalDateTime timeIn, LocalDateTime timeOut,String status) {
        this.firstName=firstName;
        this.studentId=studentId;
        this.timeIn=timeIn;
        this.timeOut=timeOut;
        this.status=status;
    }
}
