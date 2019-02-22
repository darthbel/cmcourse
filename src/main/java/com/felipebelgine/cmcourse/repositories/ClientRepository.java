package com.felipebelgine.cmcourse.repositories;

import com.felipebelgine.cmcourse.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}