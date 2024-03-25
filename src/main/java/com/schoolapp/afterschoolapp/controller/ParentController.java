package com.schoolapp.afterschoolapp.controller;

import java.util.List;
import com.schoolapp.afterschoolapp.model.Parent;
import com.schoolapp.afterschoolapp.service.ParentService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/parent")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("parent", new Parent());
        return "register-parent";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("parent") Parent parent) {
        parentService.registerParent(parent.getParentName(),parent.getChildName(), parent.getEmail(), parent.getPhone());
        return "redirect:/parents/list";
    }

    @GetMapping("/list")
    public String listParents(Model model) {
        List<Parent> parents = parentService.getAllParents();
        model.addAttribute("parents", parents);
        return "list-parents";
    }
}
