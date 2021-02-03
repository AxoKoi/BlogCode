package com.axokkoi.springsecurityapp;

import org.springframework.context.annotation.Role;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class GreetingController {

   @GetMapping
   public String hello() {
      User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

      return "authenticated Hi " + user.getUsername();
   }

   @GetMapping("/admin")
   public String helloForAdmin() {
      return "you must be an admin!";
   }
}
