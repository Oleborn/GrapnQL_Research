package Oleborn.GraphQL_Research.repository;

import Oleborn.GraphQL_Research.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}