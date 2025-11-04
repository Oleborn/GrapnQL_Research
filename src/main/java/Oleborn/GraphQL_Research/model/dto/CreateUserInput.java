package Oleborn.GraphQL_Research.model.dto;

import Oleborn.GraphQL_Research.dictionary.Role;

public record   CreateUserInput(
        String name,
        String email,
        Role role
) {
}