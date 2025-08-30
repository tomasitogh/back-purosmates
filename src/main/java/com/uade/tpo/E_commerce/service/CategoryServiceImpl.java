package com.uade.tpo.E_commerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.E_commerce.entity.Category;
import com.uade.tpo.E_commerce.exceptions.CategoryDuplicateException;
import com.uade.tpo.E_commerce.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
   private CategoryRepository categoryRepository;

    @SuppressWarnings("override") // To indicate that this method overrides a method in the interface
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
    
    
    @SuppressWarnings("override")
    public Optional<Category> getCategoryById(long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @SuppressWarnings("override")
    public Category createCategory(String description) throws CategoryDuplicateException {
        List<Category> categories = categoryRepository.findByDescription(description);
        if (categories.isEmpty()) {
            return categoryRepository.save(new Category(description));
        } else {
            throw new CategoryDuplicateException();
        }
    }
    
}