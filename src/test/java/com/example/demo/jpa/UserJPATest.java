package com.example.demo.jpa;

import com.example.demo.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author WangNan, nan.wang@htouhui.com
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserJPATest {

    @Autowired
    private UserJPA userJPA;

    @Test
    public void findByUsername() throws Exception {

        UserEntity admin = userJPA.findByUsername("admin");
        System.out.println("\n\n\n" + admin + "\n\n\n");
    }

}