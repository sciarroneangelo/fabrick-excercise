package dev.asciarrone.fabricktest.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.asciarrone.fabricktest.db.dto.TransactionDto;

public interface TransactionRepository extends JpaRepository<TransactionDto, Long> {

}
