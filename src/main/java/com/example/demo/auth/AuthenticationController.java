package com.example.demo.auth;

import com.example.demo.db.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
@RequestMapping("/")
@Controller
public class AuthenticationController {
    private final AuthService authService;
    private final UsersRepository repository;

    @GetMapping
    public void getPage(HttpServletResponse resp){
        if (authService.hasAuthority("admin")){
            try {
                resp.sendRedirect("/admin/manufacture");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                resp.sendRedirect("/user/manufacture");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @GetMapping("error")
    public ModelAndView getError(){
        ModelAndView modelAndView = new ModelAndView("error");
        System.out.println("hi");
        return modelAndView;
    }


}
