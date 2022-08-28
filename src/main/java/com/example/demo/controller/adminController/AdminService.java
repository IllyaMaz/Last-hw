package com.example.demo.controller.adminController;

import com.example.demo.db.entity.Manufacturer;
import com.example.demo.db.entity.Product;
import com.example.demo.db.entity.Role;
import com.example.demo.db.entity.Users;
import com.example.demo.db.repository.ManufacturerRepository;
import com.example.demo.db.repository.ProductRepository;
import com.example.demo.db.repository.RoleRepository;
import com.example.demo.db.repository.UsersRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Service
public class AdminService {
    private UUID idChangeManufacture;
    private UUID idChangeProduct;
    private UUID idChangeUser;
    private final ManufacturerRepository manufacturerRepository;
    private final ProductRepository productRepository;
    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;

    public List<Manufacturer> getAllManufacture(){
        return manufacturerRepository.findAll();
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public List<Role> getAllRole() { return roleRepository.findAll(); }

    public void deleteManufacture(Map<String,String> map, HttpServletResponse resp){
        UUID id = UUID.fromString(map.get("id"));
        Optional<Manufacturer> byId = manufacturerRepository.findById(id);
        manufacturerRepository.delete(byId.get());

        try {
            resp.sendRedirect("/admin/manufacture");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(Map<String,String> map, HttpServletResponse resp){
        UUID id = UUID.fromString(map.get("id"));
        Optional<Product> byId = productRepository.findById(id);
        productRepository.delete(byId.get());

        try {
            resp.sendRedirect("/admin/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Map<String,String> map, HttpServletResponse resp){
        UUID id = UUID.fromString(map.get("id"));
        Optional<Users> byId = usersRepository.findById(id);
        usersRepository.delete(byId.get());

        try {
            resp.sendRedirect("/admin/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addManufacture(Map<String,String> map, HttpServletResponse resp){
        String name = map.get("name");
        if (name.equals("")){
            try {
                resp.sendRedirect("/error/manufacture/add");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(name);
            manufacturerRepository.save(manufacturer);

            try {
                resp.sendRedirect("/admin/manufacture/add");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addProduct(Map<String,String> map, HttpServletResponse resp){
        if (map.get("name").equals("") || map.get("price").equals("") || map.get("manufacture").equals("")){
            try {
                resp.sendRedirect("/error/product/add");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String name = map.get("name");
            BigDecimal price = BigDecimal.valueOf(Float.valueOf(map.get("price"))).setScale(2, RoundingMode.HALF_EVEN);
            String manufacture = map.get("manufacture");
            Optional<Manufacturer> byName = manufacturerRepository.findByName(manufacture);
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setManufacturer(byName.get());

            productRepository.save(product);

            try {
                resp.sendRedirect("/admin/product/add");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addUser(Map<String,String> map, HttpServletResponse resp){
        String email = map.get("email");
        String password = map.get("password");
        String firstName = map.get("firstName");
        String lastName = map.get("lastName");
        String role = map.get("role");

        if (email.equals("") || password.equals("") || firstName.equals("") || lastName.equals("") || role.equals("")){
            try {
                resp.sendRedirect("/error/users/add");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Optional<Role> byName = roleRepository.findByName(role);
            Users user = new Users();
            user.setEmail(email);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setRole(byName.get());

            usersRepository.save(user);

            try {
                resp.sendRedirect("/admin/users/add");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void changeManufacture(Map<String,String> map, HttpServletResponse resp){
        String name = map.get("name");
        Optional<Manufacturer> byId = manufacturerRepository.findById(idChangeManufacture);
        Manufacturer manufacturer = byId.get();
        if (!name.equals("")){
            manufacturer.setName(name);
        }
        manufacturerRepository.save(manufacturer);

        try {
            resp.sendRedirect("/admin/manufacture");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeProduct(Map<String,String> map, HttpServletResponse resp){
        String name = map.get("name");
        String price = map.get("price");
        String manufacture = map.get("manufacture");
        Optional<Product> byId = productRepository.findById(idChangeProduct);
        Product product = byId.get();

        if (!name.equals("")){
            product.setName(name);
        }

        if (!price.equals("")){
            product.setPrice(BigDecimal.valueOf(Float.valueOf(price)).setScale(2,RoundingMode.HALF_EVEN));
        }

        if (!manufacture.equals("")){
            Optional<Manufacturer> byName = manufacturerRepository.findByName(manufacture);
            product.setManufacturer(byName.get());
        }

        productRepository.save(product);

        try {
            resp.sendRedirect("/admin/product");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeUser(Map<String,String> map, HttpServletResponse resp){
        String email = map.get("email");
        String password = map.get("password");
        String firstName = map.get("firstName");
        String lastName = map.get("lastName");
        String role = map.get("role");

        Optional<Users> byId = usersRepository.findById(idChangeUser);
        Users user = byId.get();
        if (!email.equals("")){
            user.setEmail(email);
        }

        if (!password.equals("")){
            user.setPassword(password);
        }

        if (!firstName.equals("")){
            user.setFirstName(firstName);
        }

        if (!lastName.equals("")){
            user.setLastName(lastName);
        }

        if (!role.equals("")){
            Optional<Role> byName = roleRepository.findByName(role);
            user.setRole(byName.get());
        }

        usersRepository.save(user);

        try {
            resp.sendRedirect("/admin/users");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
