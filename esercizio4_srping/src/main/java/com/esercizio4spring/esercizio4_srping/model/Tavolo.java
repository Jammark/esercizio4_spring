package com.esercizio4spring.esercizio4_srping.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Component
@Scope("prototype")
@Entity
@Table(name = "tavoli")
@NoArgsConstructor
public class Tavolo {

	@Id
	@GeneratedValue
	private Long id;
	private int coperti, numero;
	private boolean occupato;

	@Autowired
	public Tavolo(@Value("6") int coperti, @Qualifier("getNumeroTavolo") int numero, @Value("false") boolean occupato) {
		super();
		this.coperti = coperti;
		this.numero = numero;
		this.occupato = occupato;
	}

}
