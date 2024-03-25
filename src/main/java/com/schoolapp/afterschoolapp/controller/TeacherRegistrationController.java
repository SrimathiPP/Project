package com.schoolapp.afterschoolapp.controller;

import com.schoolapp.afterschoolapp.model.Teacher;
import com.schoolapp.afterschoolapp.repository.TeacherRegDTO;
import com.schoolapp.afterschoolapp.service.TeacherService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registration")
@Slf4j
public class TeacherRegistrationController {
    @Autowired
    private TeacherService teacherService;

    @ModelAttribute("teacher")
    public TeacherRegDTO teacherRegistrationDto() {
        System.out.println("IN  TeacherRegController->TeacherRegistrationDto()");
        return new TeacherRegDTO();
    }
    //Retrieving Registration Page
    @GetMapping
    public String showRegistrationForm(Model model) {
        log.info("Registration Page Displayed");
        return "registration";
    }
    //Checks for successful registration
    @PostMapping
    public String registerUserAccount(@ModelAttribute("teacher") @Valid TeacherRegDTO teacherDto,
                                      BindingResult result) {
        System.out.println("IN  POST MAPPING TeacherRegController->registerTeacherAccount()");
        Teacher existing = teacherService.findByEmail(teacherDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        teacherService.save(teacherDto);
        log.info("Registration Success");
        return "redirect:/registration?success";
    }
   /* @PostMapping("/adminlogin")
    public ResponseEntity<Teacher> login(@RequestParam String email,
                                         @RequestParam String password) {
        Teacher teacher = teacherService.login(email, password);
        return ResponseEntity.ok(teacher);
    }*/

}
