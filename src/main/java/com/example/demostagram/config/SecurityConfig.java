package com.example.demostagram.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity //해당 파일(SecurityConfig)로 시큐리티를 활성화
@Configuration //IOC
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super 삭제 - 기존 시큐리티가 가지고 있는 기능이 다 비활성화 된다

        http
                .authorizeRequests()
                .mvcMatchers("/","/css/**","/scripts/**","/plugin/**","/fonts/**","/api/**","/auth/**","/image/**")
                .permitAll();

        http
                .authorizeRequests()
                .antMatchers("/", "/user/**","/image/**", "/subscribe/**", "/comment/**", "/api/**","/auth/**")
                .permitAll()
                .anyRequest()
                .authenticated() ;



    }
}
