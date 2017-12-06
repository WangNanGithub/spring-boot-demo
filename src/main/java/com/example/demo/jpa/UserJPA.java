package com.example.demo.jpa;

import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPA extends JpaRepository<UserEntity, Long> {

    // 使用SpringDataJPA方法定义查询
    UserEntity findByUsername(String username);

}
