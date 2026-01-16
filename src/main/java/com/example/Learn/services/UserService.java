package com.example.Learn.services;

import com.example.Learn.entities.Address;
import com.example.Learn.entities.Profile;
import com.example.Learn.entities.User;
import com.example.Learn.repositories.AddressRepository;
import com.example.Learn.repositories.ProfileRepository;
import com.example.Learn.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;

    //    @Transactional
    public void showRelatedEntities() {
        var user = profileRepository.findById(1).orElseThrow();
        System.out.println(user.getBio());
    }

    public void getAddressEntity() {
        var address = addressRepository.findById(1).orElseThrow();
        System.out.println(address.getVillage());
    }

    public void persistRelated() {
        var user = User.builder()
                .name("Rmana")
                .email("Re@gmail")
                .password("pass")
                .build();

        var address = Address.builder()
                .state("AP")
                .pincode("23423")
                .village("Vedireswarm")
                .street("Ster")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        var user = userRepository.findById(2).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }
}
