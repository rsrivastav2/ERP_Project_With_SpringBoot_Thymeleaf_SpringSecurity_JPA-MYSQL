package com.roze.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roze.domain.Contract;

@Repository
public interface ContractRepository extends CrudRepository<Contract, Long> {
}
