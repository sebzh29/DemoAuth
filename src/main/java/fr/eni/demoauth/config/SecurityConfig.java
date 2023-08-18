package fr.eni.demoauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    //Regle autentification  page a proteger ou non
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        System.err.println("****** SecurityFilterChain Started ******");
        return httpSecurity.authorizeHttpRequests(auth->{
                    auth.requestMatchers("/mon-compte/**").authenticated();
//                    auth.requestMatchers("/admin").hasRole("ADMIN");//ROLE_ADMIN
                    auth.anyRequest().permitAll();
                })
                .formLogin(Customizer.withDefaults())   //va afficher le form de login par defaut
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
