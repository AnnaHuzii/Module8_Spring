package com.goitcd5.module8_spring.controller;


import com.goitcd5.module8_spring.dao.role.Role;
import com.goitcd5.module8_spring.dao.role.RoleService;
import com.goitcd5.module8_spring.dao.user.User;
import com.goitcd5.module8_spring.controller.user.UserRepository;
import com.goitcd5.module8_spring.dao.user.UserSecurity;
import com.goitcd5.module8_spring.dao.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@Controller
@RequestMapping("/")
@AllArgsConstructor
@Log
public class MainController {
    private final UserService userService;
    private final RoleService roleService;
    private final UserRepository userRepository;

    @GetMapping("/")
    public ModelAndView init() {
        User firstDefaultAdmin = userService.findByEmail("admin@mail");
        Role admin = roleService.findByName("ADMIN");
        if ( !firstDefaultAdmin.getRoles().contains(admin)) {
            firstDefaultAdmin.addRoles(admin);
            userRepository.save(firstDefaultAdmin);
        }
        User firstDefaultUser = userService.findByEmail("user@mail");
        Role user = roleService.findByName("USER");
        if ( ! firstDefaultUser.getRoles().contains(user)) {
            firstDefaultUser.addRoles(user);
            userRepository.save(firstDefaultUser);
        }
        ModelAndView modelAndView = new ModelAndView("main_page");
        return modelAndView;

    }

    @GetMapping("/registration")
    public ModelAndView showForm(UserSecurity user, BindingResult bindingResult) { //without BindingResult doesn't work
        ModelAndView modelAndView = new ModelAndView("sign-up-form");
        modelAndView.addAllObjects(Map.of("user", user));
        return modelAndView;
    }

    @PostMapping("/registration")
    public RedirectView submitForm(@ModelAttribute("user") UserSecurity user) {

        userService.saveUser(user);
        return new RedirectView("/");
    }


}
