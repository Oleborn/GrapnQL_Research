package Oleborn.GraphQL_Research.service;

import Oleborn.GraphQL_Research.dictionary.Role;
import Oleborn.GraphQL_Research.model.UserEntity;
import Oleborn.GraphQL_Research.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class DataInitializer {


    private final UserRepository userRepository;


    @PostConstruct
    public void init() {
        if (userRepository.count() > 0) return;


        UserEntity alice = UserEntity.builder()
                .name("Alice")
                .email("alice@example.com")
                .roles(List.of(Role.ADMIN))
                .build();


        UserEntity bob = UserEntity.builder()
                .name("Bob")
                .email("bob@example.com")
                .roles(List.of(Role.USER))
                .build();


        userRepository.saveAll(List.of(alice, bob));

    }
}