package com.example.demo.controller.errorController;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/error")
@Controller
///error/createUser
public class ErrorController {
    private final ErrorService errorService;

    @GetMapping("/manufacture/add")
    public ModelAndView getErrorAddManufacture(){
        ModelAndView modelAndView = new ModelAndView("errorAddManufacture");
        return modelAndView;
    }

    @GetMapping("/product/add")
    public ModelAndView getErrorAddProduct(){
        ModelAndView modelAndView = new ModelAndView("errorAddProduct");
        modelAndView.addObject("manufacture",errorService.getAllManufacture());
        return modelAndView;
    }

    @GetMapping("/users/add")
    public ModelAndView getErrorAddUser(){
        ModelAndView modelAndView = new ModelAndView("errorAddUser");
        modelAndView.addObject("roles",errorService.getAllRole());
        return modelAndView;
    }

    @GetMapping("/createUser")
    public ModelAndView getErrorCreateUser(){
        ModelAndView modelAndView = new ModelAndView("errorCreateUser");
        return modelAndView;
    }
}
