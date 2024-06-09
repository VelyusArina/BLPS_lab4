package ru.artemiyandarina.blps_lab4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemiyandarina.blps_lab4.entity.EnterRecord;

import java.time.LocalDateTime;
import java.util.List;

public interface EnterRecordRepository extends JpaRepository<EnterRecord, Long> {
    List<EnterRecord> findAllByTimestampBetween(LocalDateTime start, LocalDateTime end);
}

