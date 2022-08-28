package com.example.demo.errorController;

import com.example.demo.db.entity.Manufacturer;
import com.example.demo.db.entity.Role;
import com.example.demo.db.repository.ManufacturerRepository;
import com.example.demo.db.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ErrorService {
    private final ManufacturerRepository manufacturerRepository;
    private final RoleRepository roleRepository;

    public List<Manufacturer> getAllManufacture() {
        return manufacturerRepository.findAll();
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

}
