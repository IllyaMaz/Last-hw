package com.example.demo.controller.userController;

import com.example.demo.db.repository.ManufacturerRepository;
import com.example.demo.db.repository.ProductRepository;
import com.example.demo.db.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RequestMapping("/user/*")
@Controller
public class UserController {
    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;

    @GetMapping("/manufacture")
    public ModelAndView getManufacture(){
        ModelAndView modelAndView = new ModelAndView("userManufactur");
        modelAndView.addObject("manufacturer",manufacturerRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/product")
    public ModelAndView getProduct(){
        ModelAndView modelAndView = new ModelAndView("userProduct");
        modelAndView.addObject("products",productRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView getUsers(){
        ModelAndView modelAndView = new ModelAndView("userUsers");
        modelAndView.addObject("users",usersRepository.findAll());
        return modelAndView;
    }
}
