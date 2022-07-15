package com.example.patagoniatest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PatagoniaTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatagoniaTestApplication.class, args);
    }
  /*  @Bean
    CommandLineRunner run(ClientService employeeService) {
        return args -> {
         *//*   employeeService.saveRole(new Role(null, "ROLE_USER"));
            employeeService.saveRole(new Role(null, "ROLE_ADMINISTRATOR"));
            employeeService.saveRole(new Role(null, "ROLE_MANAGER"));*//*


           employeeService.addRoleToClient("Agustina Fernandez", "ROLE_USER");

        };*/


}