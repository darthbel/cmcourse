package com.felipebelgine.cmcourse;

import com.felipebelgine.cmcourse.domain.Category;
import com.felipebelgine.cmcourse.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CmcourseApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    public static void main(String[] args) {
        SpringApplication.run(CmcourseApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "IT");
        Category cat2 = new Category(null, "Office");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));

    }
}

