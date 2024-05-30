package ru.gb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.domain.Fraud;

@Repository
public interface FraudChecksRepository extends JpaRepository<Fraud, Integer> {
}
