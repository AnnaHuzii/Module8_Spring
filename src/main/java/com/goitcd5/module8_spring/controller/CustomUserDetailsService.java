package com.goitcd5.module8_spring.controller;


import com.goitcd5.module8_spring.dao.user.User;
import com.goitcd5.module8_spring.controller.user.UserRepository;
import com.goitcd5.module8_spring.dao.user.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user= userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        return UserSecurity.fromUser(user);
    }


}

