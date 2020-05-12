package com.tms.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@ComponentScan("com.tms.*")
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService detailsService;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider);

//        auth.userDetailsService(detailsService);

//        auth.inMemoryAuthentication()
//                    .withUser("user").password("{noop}user").roles("USER")
//                .and()
//                    .withUser("admin").password("{noop}admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/first").permitAll()
                    .antMatchers("/second").authenticated()
                    .antMatchers("/third").hasRole("ADMIN")
                .and()
                    .formLogin()
                .and()
                    .logout().logoutSuccessUrl("/")
                .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
}
