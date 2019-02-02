package com.felipebelgine.cmcourse.repositories;

import com.felipebelgine.cmcourse.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<Product, Integer> {

}
