package dev.asciarrone.fabricktest.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.asciarrone.fabricktest.db.dto.TransactionTypeDto;

public interface TransactionTypeRepository extends JpaRepository<TransactionTypeDto, Long> {

	TransactionTypeDto findByValue(String value);

}
