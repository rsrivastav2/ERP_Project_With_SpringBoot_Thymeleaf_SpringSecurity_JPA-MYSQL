package com.roze.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roze.domain.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
