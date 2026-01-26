package com.example.Learn;

import com.example.Learn.entities.Address;
import com.example.Learn.entities.Profile;
import com.example.Learn.repositories.ProfileRepository;
import com.example.Learn.repositories.UserRepository;
import com.example.Learn.services.ProductService;
import com.example.Learn.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.Learn.entities.User;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class LearnApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(LearnApplication.class, args);

//        var productService = context.getBean(ProductService.class);
//        var products = productService.getProducts();
//        products.forEach(System.out::println);

        var userService = context.getBean(UserService.class);
        userService.fetchUsers();

    }

}


//
//        var repository = context.getBean(UserRepository.class);
//        var profileRepository = context.getBean(ProfileRepository.class);
//
//        Profile profile = new Profile();
//        profile.setBio("Software developer");
//        profile.setPhoneNumber("1234567890");
//        profile.setDateOfBirth(LocalDate.of(1998, 5, 10));
//        profile.setLoyaltyPoints(100);
//        profile.setUser(repository.findById(2).orElseThrow());
//
//        profileRepository.save(profile);


//        var user = User.builder()
//                .name("Venkat")
//                .password("0000")
//                .email("VR@gmail.com")
//                .build();

//        var user = new User();
//        user.setName("Venkat");
//        user.setEmail("VR@gmail.com");
//        user.setPassword("0000");
//
//        repository.save(user);

//        repository.findAll().forEach(user -> System.out.println(user.getName()));

//        repository.deleteById(1);
