package com.api.parkingcontrol.configs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true) //habilitar segurança por anotaçoes
public class WebSecurityConfigAtualizada {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception{
        http
                .httpBasic()//utilizar do http basic
                .and()
                .authorizeHttpRequests()
                //comentei os de baixo para fazer as autorizaçoes atraves de annotations no controller
//                .antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll()//permitir acesso a todos
//                .antMatchers(HttpMethod.POST, "/parking-spot/**").hasAnyRole("USER","ADMIN")//permitir acesso a cadastrados
//                .antMatchers(HttpMethod.PUT, "/parking-spot/**").hasRole("USER")//permitir acesso a cadastrados
//                .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN")//apenas admins
                .anyRequest().authenticated()   //para todas as requisiçoes deve estar autenticado
                .and()
                .csrf().disable();//desbilitar bloqueio de solicitaçoes json para post,delete,etc
        //se csrf estiver habilitado é preciso enviar o token csrf gerado pelo spring
        //para ser autenticado

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http)  throws Exception{
//        http
//                .httpBasic()//utilizar do http basic
//                .and()
//                .authorizeHttpRequests()
//                .antMatchers(HttpMethod.GET, "/parking-spot/**").permitAll()//permitir acesso a todos
//                .antMatchers(HttpMethod.POST, "/parking-spot/**").hasAnyRole("USER","ADMIN")//permitir acesso a cadastrados
//                .antMatchers(HttpMethod.PUT, "/parking-spot/**").hasRole("USER")//permitir acesso a cadastrados
//                .antMatchers(HttpMethod.DELETE, "/parking-spot/**").hasRole("ADMIN")//apenas admins
//                .anyRequest().authenticated()   //para todas as requisiçoes deve estar autenticado
//                .and()
//                .csrf().disable();//desbilitar bloqueio de solicitaçoes json para post,delete,etc
//        //se csrf estiver habilitado é preciso enviar o token csrf gerado pelo spring
//        //para ser autenticado
//
//        return http.build();
//    }
}
