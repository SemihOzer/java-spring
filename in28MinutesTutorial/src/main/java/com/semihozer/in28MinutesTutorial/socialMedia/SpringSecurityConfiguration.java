package com.semihozer.in28MinutesTutorial.socialMedia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        //All request should be authenticated
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        //If a request is not authenticated, show a web page
        http.httpBasic(Customizer.withDefaults());

        //CSRF -> POST, PUT
        http.csrf().disable();

        return http.build();
    }

}
