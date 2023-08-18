package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.httpBasic()//utilizar do http basic
                .and()
                .authorizeHttpRequests()
                .anyRequest()   //para todas as requisiçoes
                .authenticated()//deve estar autenticado
                .and()
                .csrf().disable();//desbilitar bloqueio de solicitaçoes json para post,delete,etc
                //se csrf estiver habilitado é preciso enviar o token csrf gerado pelo spring
                //para ser autenticado
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth.inMemoryAuthentication()
                .withUser("ryan")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN");
    }

    @Bean //
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
