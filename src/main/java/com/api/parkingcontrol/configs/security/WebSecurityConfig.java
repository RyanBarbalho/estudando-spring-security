package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.httpBasic()//utilizar do http basic
                .and()
                .authorizeHttpRequests()
                .anyRequest()   //para todas as requisiçoes
                .authenticated();
        http.cors().and().csrf().disable();
    }

}
