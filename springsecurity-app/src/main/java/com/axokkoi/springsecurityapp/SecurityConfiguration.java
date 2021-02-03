package com.axokkoi.springsecurityapp;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   //Declare in memory users
   @Bean
   @Override
   public UserDetailsService userDetailsService() {
      UserDetails user = User.withUsername("user")
              .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("user123"))
              .roles("USER")
              .build();

      UserDetails admin = User.withUsername("admin")
              .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin123"))
              .roles("ADMIN")
              .build();
      return new InMemoryUserDetailsManager(user, admin);
   }

   //declare http basic authentication for all requests
   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http
          .authorizeRequests()
              .antMatchers("/admin/**").hasRole("ADMIN")
              .anyRequest().authenticated()
              .and().httpBasic();
   }
}
