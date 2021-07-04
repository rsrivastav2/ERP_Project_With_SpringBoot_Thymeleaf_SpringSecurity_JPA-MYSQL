package com.roze.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roze.domain.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>{
}
