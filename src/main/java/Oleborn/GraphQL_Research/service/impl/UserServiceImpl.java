package Oleborn.GraphQL_Research.service.impl;

import Oleborn.GraphQL_Research.exception.UserNotFoundException;
import Oleborn.GraphQL_Research.model.dto.CreateUserInput;
import Oleborn.GraphQL_Research.model.dto.FilterInput;
import Oleborn.GraphQL_Research.model.UserEntity;
import Oleborn.GraphQL_Research.repository.UserRepository;
import Oleborn.GraphQL_Research.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers(FilterInput filter) {

        System.out.println(filter);

        Pageable pageable = PageRequest.of(
                filter.getOffsetOrDefault(),
                filter.getLimitOrDefault(),
                Sort.by(Sort.Direction.ASC, filter.getSortFieldOrDefault())
        );

        return userRepository.findAll(pageable).stream().toList();
    }

    @Override
    public UserEntity getUser(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("Сущность не найдена")
        );
    }

    @Override
    @Transactional
    public UserEntity createUser(CreateUserInput input) {

        UserEntity userEntity = UserEntity.builder()
                .name(input.name())
                .email(input.email())
                .roles(List.of(input.role()))
                .build();

        return userRepository.save(userEntity);
    }
}
