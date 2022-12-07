package com.example.day_17_1118_blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailService customUserDetailsService;

    @Autowired
    private CustomFilter customFilter;

    @Autowired
    private AccessDeniedHandlerCustom accessDeniedHandlerCustom;

    @Autowired
    private AuthenticationEntryPointCustom authenticationEntryPointCustom;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/auth/**", "/api/v1/**").permitAll() // Cho phép ai cũng có thể đi qua
                .antMatchers("/api/admin/**").permitAll() // Cần quyền admin mới được đi qua
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPointCustom) // Xử lý lỗi authentication
                .accessDeniedHandler(accessDeniedHandlerCustom) // Xử lý lỗi forbidden
                .and()
                .logout()
                .logoutUrl("/handle-logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
