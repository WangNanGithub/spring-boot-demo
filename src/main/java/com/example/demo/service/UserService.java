package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserJPA userJPA;

    @Autowired
    public UserService(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("user name : {}", username);
        UserEntity user = userJPA.findByUsername(username);
        LOGGER.info("user : {}", user);
        if (user == null) {
            throw new UsernameNotFoundException("未查询到用户：" + username + "信息！");
        }
        return user;
    }
}
