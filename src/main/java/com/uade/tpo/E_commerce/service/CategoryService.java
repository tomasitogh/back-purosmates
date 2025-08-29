package com.uade.tpo.E_commerce.service;

import java.util.List;
import java.util.Optional;

import com.uade.tpo.E_commerce.entity.Category;
import com.uade.tpo.E_commerce.exceptions.CategoryDuplicateException;

public interface CategoryService {
    public List<Category> getCategories();
    public Optional<Category> getCategoryById(long categoryId);
    public Category createCategory(String description) throws CategoryDuplicateException;
}
