package com.schoolapp.afterschoolapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ActivityController {
    @GetMapping("/activities")
    public String showActivityImg() {

        log.info("Activity Image is diplaying");
        return "activities";
    }
}
