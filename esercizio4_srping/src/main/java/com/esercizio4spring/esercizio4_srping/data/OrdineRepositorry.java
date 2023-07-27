package com.esercizio4spring.esercizio4_srping.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esercizio4spring.esercizio4_srping.model.Ordine;

@Repository
public interface OrdineRepositorry extends JpaRepository<Ordine, Long> {

	List<Ordine> findByNumero(int numero);
}
