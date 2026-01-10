package com.example.Learn;

import com.example.Learn.entities.Address;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.Learn.entities.User;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);

//        var user = User.builder()
//                .name("Venkat")
//                .password("0000")
//                .email("VR@gmail.com")
//                .build();

        var user = new User();
        user.setName("Venkat");
        user.setEmail("VR@gmail.com");
        user.setPassword("0000");
        user.addTag("Leaner");

        System.out.println(user.toString());

    }

}
