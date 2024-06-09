package ru.artemiyandarina.blps_lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemiyandarina.blps_lab4.entity.Petition;

import java.util.Optional;

public interface PetitionRepository extends JpaRepository<Petition, Long> {
    Optional<Petition> findById(Long id);
}
