package com.schoolapp.afterschoolapp.controller;

import com.schoolapp.afterschoolapp.model.Student;
import com.schoolapp.afterschoolapp.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    //Retrieving student list
    @GetMapping("/students")
    public String studentList(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        log.info("Student Details Retrieved");
        return "students";
    }
    @GetMapping("/students/studentmgt")
    public String studentList1(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        log.info("Student Details Retrieved");
        return "studentsmgt";
    }
    //showing the student form for Adding new student
  /*  @GetMapping("/students/studentmgt/new")
    public String showNewStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        log.info("New Student");
        return "studentform";
    }*/

    //Adding new student
    @GetMapping("/students/studentmgt/add")
    public String showNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        log.info("New Student");
        return "studentform";
    }

    //List of students after adding new student
    @PostMapping("/students/studentmgt/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        log.info("New List of Students Retrieved");
        return "redirect:/students";
    }

    //Retrieving student detail to update
    @GetMapping("/students/studentmgt/update/{id}")
    public String showUpdateStudent(@PathVariable Long id, Model model) {
        System.out.println("Preparing to show edit form");

        Student student = studentService.getStudentById(id);
        model.addAttribute("student",student);

        System.out.println("Student ID:"+student.getStudentId());
        System.out.println("Student DOB:"+student.getDOB());
        log.info("Student Details to Update");
        return "editstudent";
    }

    //Updating student details
    @PostMapping("/students/studentmgt/save/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setStudentId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setMotherName(student.getMotherName());
        existingStudent.setFatherName(student.getFatherName());
        existingStudent.setM_contactNo(student.getM_contactNo());
        existingStudent.setF_contactNo(student.getF_contactNo());
        existingStudent.setMedicalConcerns(student.getMedicalConcerns());
        existingStudent.setAddress(student.getAddress());
existingStudent.setDOB(student.getDOB());
existingStudent.setGender(student.getGender());
existingStudent.setGrade(student.getGrade());
existingStudent.setEmail(student.getEmail());
        studentService.updateStudent(existingStudent);
        log.info("Student Details Updated");
        return "redirect:/students/studentmgt";
    }

    //Deleting the Student
    @GetMapping("/students/studentmgt/{id}")
    public String deleteStudent(@PathVariable Long id) {
        this.studentService.deleteStudentById(id);
        log.info("Student Deleted");
        return "redirect:/students/studentmgt";
    }

}