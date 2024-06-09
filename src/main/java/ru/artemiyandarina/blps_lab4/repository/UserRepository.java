package ru.artemiyandarina.blps_lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemiyandarina.blps_lab4.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findUserById(Long id);
    Optional<User> findByEmailAndPasswordHash(String email, String password);
    Boolean existsUserByEmail(String email);

}
