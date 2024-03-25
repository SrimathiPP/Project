package com.schoolapp.afterschoolapp.service;

import com.schoolapp.afterschoolapp.model.Attendance;
import com.schoolapp.afterschoolapp.model.Student;
import com.schoolapp.afterschoolapp.repository.AttendanceRepository;
import com.schoolapp.afterschoolapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AttendanceServiceImpl  implements AttendanceService{
    private final AttendanceRepository attendanceRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
   private  StudentServiceImpl studentServiceImpl;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public void markAttendance(Long studentId,String firstName, LocalDateTime timeIn, LocalDateTime timeOut,LocalDate date,String status) {
        Attendance attendance = new Attendance(studentId, firstName,timeIn, timeOut,date,status);
        attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAttendanceRecords(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }
}
