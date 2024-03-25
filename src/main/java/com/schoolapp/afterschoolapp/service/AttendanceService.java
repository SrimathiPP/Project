package com.schoolapp.afterschoolapp.service;

import com.schoolapp.afterschoolapp.model.Attendance;
import com.schoolapp.afterschoolapp.model.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AttendanceService {
    void markAttendance(Long studentId, String firstName,LocalDateTime timeIn, LocalDateTime timeOut,LocalDate date,String status);

   // void markAttendance(S student, LocalDateTime timeIn, LocalDateTime timeOut);

    List<Attendance> getAttendanceRecords(LocalDate date);
}
