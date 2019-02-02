package com.felipebelgine.cmcourse.services;

import com.felipebelgine.cmcourse.domain.Category;
import com.felipebelgine.cmcourse.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;

    public Category find(Integer id) {
        Optional<Category> obj = repo.findById(id);
        return obj.orElse(null);
    }
}
