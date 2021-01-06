package com.ludmylla.dsdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ludmylla.dsdelivery.entities.Order;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<Order, Long> {

}
