package com.arthursong.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Administrator on 2018/7/27.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http //
            .authorizeRequests() //
            .antMatchers("/css/**","/index").permitAll() //
            .antMatchers("/user/**").hasRole("USER")//
            .antMatchers("/blog/**").hasRole("USER") //
            .and() //
            .formLogin().loginPage("/login").failureUrl("/login-error") //
            .and() //
            .exceptionHandling().accessDeniedPage("/403");
        http.logout().logoutSuccessUrl("/");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
            .inMemoryAuthentication() //
            .withUser("arthursong") //
            .password("123456") //
            .roles("USER");
    }

}
