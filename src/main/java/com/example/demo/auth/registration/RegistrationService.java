package com.example.demo.auth.registration;

import com.example.demo.db.entity.Role;
import com.example.demo.db.entity.Users;
import com.example.demo.db.repository.RoleRepository;
import com.example.demo.db.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RegistrationService {
    private final RoleRepository roleRepository;
    private final UsersRepository usersRepository;


    public void createUser(Map<String,String> req, HttpServletResponse resp){
        String email = req.get("email");
        String password = req.get("password");
        String firstName = req.get("firstName");
        String lastName = req.get("lastName");
        if (email.equals("") || password.equals("") || firstName.equals("") || lastName.equals("")){
            try {
                resp.sendRedirect("/error/createUser");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Optional<Role> role = roleRepository.findByName("user");

            Users user = new Users();
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setRole(role.get());
            usersRepository.save(user);

            try {
                resp.sendRedirect("/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
