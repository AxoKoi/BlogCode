package com.axokoi.tomcatgreeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TomcatGreetingApplication {

   @GetMapping("/greeting/{name}")
   public ResponseEntity<String> hello(@PathVariable String name) {
      return new ResponseEntity<>("Hello " + name, HttpStatus.OK);
   }

   public static void main(String[] args) {
      SpringApplication.run(TomcatGreetingApplication.class, args);
   }

}
