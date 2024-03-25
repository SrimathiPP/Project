package com.schoolapp.afterschoolapp.config;

import com.schoolapp.afterschoolapp.service.ParentServiceImpl;
import com.schoolapp.afterschoolapp.service.TeacherServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfiguration {
    @Autowired
    private TeacherServiceImpl userService;

    //Configuring security
   /* @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("===========>IN filterChain() ");
        http
                .authorizeHttpRequests(
                        (auth) -> auth
                                .requestMatchers("/rgistration**", "/login*",
                                        "/css/*", "/js/*", "/sign-up", "/signup-process").permitAll()
                                .requestMatchers("/home").hasAnyRole("USER", "ADMIN")
                                .anyRequest().authenticated()
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login") // should point to login page
                        .successForwardUrl("/home") // must be in order thymeleaf security extras work
                        .permitAll()
                )
                .logout(
                        logout -> logout
                                .invalidateHttpSession(true)
                                .clearAuthentication(true)
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }*/
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        System.out.println("===========>IN filterChain() ");
        http.authorizeHttpRequests().requestMatchers(
                        "/registration**",
                        "/js/**",
                        "/css/**",
                        "/img/**",
                        "/webjars/**").permitAll().anyRequest().authenticated().and().formLogin()
                .loginPage("/login").permitAll().and().logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout").permitAll();
        return http.build();
    }
    /*@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests().requestMatchers("/Registration**", "/js/**", "/css/**", "/img/**", "/webjars/**")
                .permitAll().anyRequest().authenticated().and().formLogin().loginPage("/Login").permitAll().and()
                .logout().invalidateHttpSession(true).clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/Login?logout")
                .permitAll();
        log.info("Security Configured");
        return http.build();
    }*/

    //Encrypting the password
    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());//set the password encoder
        return auth;
    }/*
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        log.info("Password Encrypted");
        return new BCryptPasswordEncoder();
    }

    //DAO Authentication
    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(UserDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        log.info("Authentication Provided");
        return auth;
    }*/
}
