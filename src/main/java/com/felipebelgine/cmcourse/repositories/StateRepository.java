package com.felipebelgine.cmcourse.repositories;

import com.felipebelgine.cmcourse.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
