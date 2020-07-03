package dev.asciarrone.fabricktest.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.asciarrone.fabricktest.db.dto.CreditorDto;

public interface CreditorRepository extends JpaRepository<CreditorDto, Long> {

	public CreditorDto findByName(String name);

}
