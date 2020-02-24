package com.example.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //配置需要认证的请求
                .authorizeRequests()
                    //主页放行
                    .antMatchers("/home")
                    .permitAll()
                    //其他请求都需要认证
                    .anyRequest()
                    .authenticated()
                    .and()
                //登录表单相关配置
                .formLogin()
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .failureUrl("/login?error")
                    .permitAll()
                    .defaultSuccessUrl("/main",true)
                    .and()
                //登出相关配置
                .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                //设置加密方式
                .passwordEncoder(new BCryptPasswordEncoder())
                //设置内存用户
                .withUser("root").password(new BCryptPasswordEncoder().encode("root")).roles("ROOT");
    }
}
