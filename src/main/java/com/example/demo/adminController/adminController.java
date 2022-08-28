package com.example.demo.adminController;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/admin")
@Controller
public class adminController {
    private final AdminService service;

    @GetMapping("/manufacture")
    public ModelAndView getManufacture(){
        ModelAndView modelAndView = new ModelAndView("adminManufactur");
        modelAndView.addObject("manufacturer",service.getAllManufacture());
        return modelAndView;
    }

    @GetMapping("/product")
    public ModelAndView getProduct(){
        ModelAndView modelAndView = new ModelAndView("adminProduct");
        modelAndView.addObject("products",service.getAllProduct());
        return modelAndView;
    }

    @GetMapping("/users")
    public ModelAndView getUsers(){
        ModelAndView modelAndView = new ModelAndView("adminUser");
        modelAndView.addObject("users",service.getAllUsers());
        return modelAndView;
    }

    @PostMapping("/manufacture/delete")
    public void deleteManufacture(@RequestParam Map<String,String> map, HttpServletResponse resp){
        service.deleteManufacture(map,resp);
    }

    @PostMapping("/product/delete")
    public void deleteProduct(@RequestParam Map<String,String> map, HttpServletResponse resp){
        service.deleteProduct(map,resp);
    }

    @PostMapping("/users/delete")
    public void deleteUser(@RequestParam Map<String,String> map, HttpServletResponse resp){
        service.deleteUser(map,resp);
    }

    @GetMapping("/manufacture/add")
    public ModelAndView getAddManufacture(){
        ModelAndView modelAndView = new ModelAndView("addManufacture");
        return modelAndView;
    }

    @PostMapping("/manufacture/add")
    public void addManufacture(@RequestParam Map<String,String> map, HttpServletResponse resp){
        service.addManufacture(map,resp);
    }

    @GetMapping("/product/add")
    public ModelAndView getAddProduct(){
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("manufacture",service.getAllManufacture());
        return modelAndView;
    }

    @PostMapping("/product/add")
    public void addProduct(@RequestParam Map<String,String> map, HttpServletResponse resp){
        service.addProduct(map,resp);
    }

    @GetMapping("/users/add")
    public ModelAndView getAddUser(){
        ModelAndView modelAndView = new ModelAndView("addUser");
        modelAndView.addObject("roles",service.getAllRole());
        return modelAndView;
    }

    @PostMapping("/users/add")
    public void addUser(@RequestParam Map<String,String> map, HttpServletResponse resp){
        service.addUser(map,resp);
    }

    @GetMapping("/manufacture/change")
    public ModelAndView getChangeManufacture(@RequestParam Map<String, String> map){
        ModelAndView modelAndView = new ModelAndView("changeManufacture");
        service.setIdChangeManufacture(UUID.fromString(map.get("id")));
        return modelAndView;
    }

    @PostMapping("/manufacture/change")
    public void changeManufacture(@RequestParam Map<String,String> map, HttpServletResponse resp){
        service.changeManufacture(map,resp);
    }

    @GetMapping("/product/change")
    public ModelAndView getChangeProduct(@RequestParam Map<String,String> map){
        ModelAndView modelAndView = new ModelAndView("changeProduct");
        modelAndView.addObject("manufacture",service.getAllManufacture());
        service.setIdChangeProduct(UUID.fromString(map.get("id")));
        return modelAndView;
    }

    @PostMapping("/product/change")
    public void changeProduct(@RequestParam Map<String,String> map, HttpServletResponse resp){
        service.changeProduct(map,resp);
    }

    @GetMapping("/users/change")
    public ModelAndView getChangeUser(@RequestParam Map<String,String> map){
        ModelAndView modelAndView = new ModelAndView("changeUser");
        modelAndView.addObject("roles",service.getAllRole());
        service.setIdChangeUser(UUID.fromString(map.get("id")));
        return modelAndView;
    }

    @PostMapping("/users/change")
    public void changeUser(@RequestParam Map<String,String> map, HttpServletResponse resp){
        service.changeUser(map,resp);
    }
}
