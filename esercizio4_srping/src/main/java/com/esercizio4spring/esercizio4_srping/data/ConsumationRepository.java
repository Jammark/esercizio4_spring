package com.esercizio4spring.esercizio4_srping.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio4spring.esercizio4_srping.model.Consumation;

@Repository
public interface ConsumationRepository extends JpaRepository<Consumation, Long> {

}
