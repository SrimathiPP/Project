package com.schoolapp.afterschoolapp.model;

public class AttendanceForm {
    private Student student;
    private Attendance attendance;

    public AttendanceForm() {
        this.student = new Student();
        this.attendance = new Attendance();
    }

    // Getters and setters for student and attendance
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
}