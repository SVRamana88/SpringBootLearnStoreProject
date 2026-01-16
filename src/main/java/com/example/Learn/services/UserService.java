package com.example.Learn.services;

import com.example.Learn.entities.Profile;
import com.example.Learn.entities.User;
import com.example.Learn.repositories.AddressRepository;
import com.example.Learn.repositories.ProfileRepository;
import com.example.Learn.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
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
}
