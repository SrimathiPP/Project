package com.schoolapp.afterschoolapp.controller;

import com.schoolapp.afterschoolapp.model.Attendance;
import com.schoolapp.afterschoolapp.model.AttendanceForm;
import com.schoolapp.afterschoolapp.model.Student;
import com.schoolapp.afterschoolapp.service.AttendanceService;
import com.schoolapp.afterschoolapp.service.StudentService;
import com.schoolapp.afterschoolapp.service.StudentServiceImpl;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Slf4j
@Controller
public class AttendanceController {

    private final AttendanceService attendanceService;
    private final StudentService studentService;

    public AttendanceController(AttendanceService attendanceService, StudentService studentService) {
        this.attendanceService = attendanceService;
        this.studentService = studentService;
    }
   /* @GetMapping("/")
    public List<Student> getStudentsList(){

    }*/
   //Retrieving student detail to mark attendance
   @GetMapping("/attendance/mark/{id}")
   public String showStudentToAttendanceMark(@PathVariable Long id, Model model) {
       System.out.println("Preparing to show edit form");
           Attendance attendance = new Attendance();
       AttendanceForm attendanceform = new AttendanceForm();
           // Populate student and attendance objects if needed
           model.addAttribute("attendance", attendance);
       Student student = studentService.getStudentById(id);
      // model.addAttribute("student",student);

       System.out.println("Student ID:"+student.getStudentId());
       System.out.println("Student Name:"+student.getFirstName());
       log.info("Student Details to Update");
       return "attendance";
   }
   // @PostMapping("/attendance/mark/save/{id}")
   @PostMapping("/attendance/mark/save/")
    public String markAttendance(@RequestParam Long studentId,
                                               @RequestParam String firstName,
                                               @RequestParam LocalDateTime timeIn,
                                               @RequestParam LocalDateTime timeOut,
                                               @RequestParam LocalDate date,
                                               @RequestParam String status

    ) {
        attendanceService.markAttendance(studentId,firstName, timeIn, timeOut,date,status);
        //displaying attendance List
        //return ResponseEntity.ok().build();
       return "markedattendancelist";
    }


    @GetMapping("/attendance/records")
    public ResponseEntity<List<Attendance>> getAttendanceRecords(@RequestParam LocalDate date) {
        List<Attendance> records = attendanceService.getAttendanceRecords(date);
        return ResponseEntity.ok(records);
    }
    @GetMapping("/attendance")
       public String getStudentList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        log.info("Student Details Retrieved");
        return "attendancelist";
    }
}
