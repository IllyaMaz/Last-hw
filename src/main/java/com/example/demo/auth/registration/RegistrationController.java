package com.example.demo.auth.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RequiredArgsConstructor
@RequestMapping("/createUser")
@Controller
public class RegistrationController {
    private final RegistrationService service;

    @GetMapping
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView("createUser");
        return modelAndView;
    }

    @PostMapping
    public void createUser(@RequestParam Map<String,String> req, HttpServletResponse resp){
        service.createUser(req,resp);
    }
}
