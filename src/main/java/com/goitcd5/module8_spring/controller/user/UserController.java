package com.goitcd5.module8_spring.controller.user;

import com.goitcd5.module8_spring.dao.role.Role;
import com.goitcd5.module8_spring.dao.role.RoleService;
import com.goitcd5.module8_spring.dao.user.User;
import com.goitcd5.module8_spring.dao.user.UserSecurity;
import com.goitcd5.module8_spring.dao.user.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/app/users")
@AllArgsConstructor
@Log
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    @GetMapping("/list")
    public ModelAndView findAll() {
        log.info("Обробка запиту пошуку всіх користувачів");
        List<User> list = userService.findAll();
        ModelAndView modelAndView = new ModelAndView("user-list");
        modelAndView.addAllObjects(Map.of("list", list));
        return modelAndView;

    }

    @GetMapping("/create-new")
    public ModelAndView showForm(UserSecurity user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("edit-user-form");
        List<Role> roles = roleService.findAll();
        modelAndView.addAllObjects(Map.of("user", user, "allRoles", roles));
        return modelAndView;
    }

    @PostMapping("/create-new")
    public RedirectView submitForm(@ModelAttribute("user") UserSecurity user) {
        userService.saveUser(user);
        return new RedirectView("/app/users/list");
    }

    @RequestMapping("/update")
    public ModelAndView showEditForm(@RequestParam UUID id) {
        log.info("Обробка запиту користувача на оновлення: " + id);
        ModelAndView modelAndView = new ModelAndView("edit-user-form");
        User user = userService.findById(id);
        List<Role> roles = roleService.findAll();
        modelAndView.addAllObjects(Map.of("user", user, "allRoles", roles));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public RedirectView deleteUsers(@PathVariable UUID id) {
        log.info("Обробка запиту користувача на видалення: " + id);
        userService.deleteUser(id);
        return new RedirectView("/app/users/list");
    }

}
