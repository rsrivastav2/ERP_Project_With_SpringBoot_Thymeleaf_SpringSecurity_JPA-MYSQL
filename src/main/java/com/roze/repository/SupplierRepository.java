package com.roze.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roze.domain.Supplier;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
