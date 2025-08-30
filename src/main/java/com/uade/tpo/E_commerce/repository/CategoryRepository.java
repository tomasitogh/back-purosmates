package com.uade.tpo.E_commerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uade.tpo.E_commerce.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query(value = "SELECT c FROM Category c WHERE c.description = ?1")
    List<Category> findByDescription(String description);
}
