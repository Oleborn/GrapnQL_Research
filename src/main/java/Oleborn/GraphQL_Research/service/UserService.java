package Oleborn.GraphQL_Research.service;

import Oleborn.GraphQL_Research.model.dto.CreateUserInput;
import Oleborn.GraphQL_Research.model.dto.FilterInput;
import Oleborn.GraphQL_Research.model.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserEntity> getAllUsers(FilterInput filter);

    UserEntity getUser(UUID id);

    UserEntity createUser(CreateUserInput input);
}
