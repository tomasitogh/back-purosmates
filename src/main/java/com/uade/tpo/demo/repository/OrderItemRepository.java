package com.uade.tpo.demo.repository;

import com.uade.tpo.demo.entity.OrderItem;
import com.uade.tpo.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    void deleteByProduct(Product product);
}
