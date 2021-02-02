package com.axokoi.greetingclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class GreetingClientApplication {


   @GetMapping("/{name}")
   public ResponseEntity<String> greeting(@PathVariable String name) {

      String url = "http://tomcat-greeting:8080/greeting/{name}";
      String answer = new RestTemplate().getForObject(url, String.class, name);

      return new ResponseEntity<>(answer + " via client", HttpStatus.OK);
   }

   public static void main(String[] args) {
      SpringApplication.run(GreetingClientApplication.class, args);
   }

}
