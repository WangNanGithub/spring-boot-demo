package com.example.demo.config;

import com.example.demo.handler.LoginSuccessHandler;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final LoginSuccessHandler loginSuccessHandler;
    private final UserService userDetailsService;

    public WebSecurityConfig(LoginSuccessHandler loginSuccessHandler, UserService userDetailsService) {
        this.loginSuccessHandler = loginSuccessHandler;
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // inMemoryAuthentication 从内存中获取
//        auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");

        /*
         * jdbcAuthentication 从数据库中获取，但是默认是以security提供的表结构
         * usersByUsernameQuery 指定查询用户SQL
         * authoritiesByUsernameQuery 指定查询权限SQL
         */
//        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(query);

        // 注入userDetailsService，需要实现userDetailsService接口
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()                                                            // 配置安全策略
            .antMatchers("/hello", "/login").permitAll()                     // 定义不需要验证的页面
            .antMatchers("/admin/**").access("hasRole('ADMIN')")   // 定义需要指定权限的页面
            .antMatchers("/home/**").access("hasRole('USER')")
            .anyRequest().authenticated()                                                   // 其余的所有请求都需要验证
            .and().logout().permitAll()                                                     // 定义logout不需要验证
            .and().formLogin()                                                              // 使用form表单登录
                  .loginPage("/login").successHandler(loginSuccessHandler)
                  .failureUrl("/login?error").permitAll()
            .and().exceptionHandling().accessDeniedPage("/access_denied");
    }
}
