package com.schoolapp.afterschoolapp.controller;

import com.schoolapp.afterschoolapp.model.Teacher;
import com.schoolapp.afterschoolapp.service.TeacherService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
@Controller
@Slf4j
public class MainController {

    @Autowired
    private TeacherService teacherService;

//    @GetMapping("/")
//    public String root(HttpSession session,Authentication authentication) {
//        //return "index";
//    	System.out.println("IN  MainController->root()");
//    	System.out.println(">>>>>>>USER ="+authentication.getName());
//    	User existing = userService.findByEmail(authentication.getName());
//    	System.out.println("User firstName="+existing.getFirstName());
//    	System.out.println("User lastName="+existing.getLastName());
//    	System.out.println("User Id="+existing.getId());
//
//		System.out.println("USER ROLE="+existing.getRoles());
//
//
//		java.util.Collection<Role> roles = existing.getRoles();
//		String userRole = roles.toString();
//		System.out.println("COLLECTION USER ROLE="+userRole);
//
//		if(userRole.equals("[ROLE_SUPER]")) {
//			return "redirect:/admin";
//		}
//
//		return "redirect:/students";
//    }

    //
    // UPDATE users_roles   user_id to point to role_id that is superuser in role table
    // to enable that id to be superuser!
    //
    // example:
    // mysql> update role set name = 'ROLE_SUPER' where id = 2;
    //
    @GetMapping("/")
    public String root(HttpSession session) {

        System.out.println("IN  MainController->root()");
        session.getAttributeNames();

        Collection<? extends GrantedAuthority> userRoles;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userRoles = ((UserDetails) principal).getAuthorities();

            for (GrantedAuthority userRole : userRoles) {
                if (userRole.getAuthority().equals("ROLE_SUPER")) {
                    System.out.println("USER ROLE="+userRole.getAuthority());
                    return "redirect:/adminlogin";
                }
            }
        }

        System.out.println("USER ROLE Defaults to Regular USER");
        return "redirect:/students";
    }
    @GetMapping("/home")
    public String viewHome() {
        log.info("Home Page Retrieved");
        return "home";
    }
   /* @GetMapping("/admin")
    public String teacher(Model model) {
        log.info("Teacher Page Retrieved");
        System.out.println("IN  MainController->admin()");
        return "adminlogin";
    }*/

    @GetMapping("/login")
    public String login(Model model) {
        System.out.println("IN  MainController->login()");
        return "login";
    }
  /*  @PostMapping("/login")
    public ResponseEntity<Teacher> login(@RequestParam String email,
                                         @RequestParam String password) {
        Teacher teacher = teacherService.login(email, password);
        return ResponseEntity.ok(teacher);
    }*/
   /* @GetMapping("/parent")
    public String parentIndex() {
        log.info("Parent Page Retrieved");
        System.out.println("IN  MainController->userIndex()");
        return "parentsignup";
    }*/

    @ResponseBody
    @GetMapping("/logoutSuccess")
    public String logoutResponse()
    {
        System.out.println("IN  MainController->logoutResponse()");
        return "Logged Out!!!!";
    }
}
