package com.roze.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roze.domain.ThirdParty;

@Repository
public interface ThirdPartyRepository extends CrudRepository<ThirdParty, Long> {
}

