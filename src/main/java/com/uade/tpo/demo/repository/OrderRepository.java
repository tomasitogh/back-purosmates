package com.uade.tpo.demo.repository;

import com.uade.tpo.demo.entity.Order;
import com.uade.tpo.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
