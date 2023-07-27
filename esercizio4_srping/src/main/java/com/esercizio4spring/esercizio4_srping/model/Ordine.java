package com.esercizio4spring.esercizio4_srping.model;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Scope("prototype")
@Component
@Entity
@Table(name = "ordini")
@NoArgsConstructor
@Setter
public class Ordine {

	@Id
	@GeneratedValue
	private Long id;

	private LocalDate acquisizione;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ordine_consumazione", joinColumns = @JoinColumn(name = "consumation_id"), inverseJoinColumns = @JoinColumn(name = "ordine_id"))
	private List<Consumation> consumazioni;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tavolo_id")
	private Tavolo tavolo;
	private int numero, coperti;

	@Autowired
	public Ordine(@Qualifier("getAcquisizione") LocalDate acquisizione,
			@Qualifier("getNextConsumations") List<Consumation> consumazioni, Tavolo tavolo,
			@Qualifier("getNumeroOrdine") int numero, @Qualifier("getCoperti") int coperti) {
		super();
		this.acquisizione = acquisizione;
		this.consumazioni = consumazioni;
		this.tavolo = tavolo;
		this.numero = numero;
		this.coperti = coperti;
	}

	public double getTotale() {
		return this.coperti * getCoperto()
				+ consumazioni.stream().map(Consumation::getPrice).reduce(0.0, (val1, val2) -> val1 + val2);
	}

	private double getCoperto() {
		return 2.0;
	}

	@Override
	public String toString() {
		return "Ordine [\nacquisizione=" + acquisizione + ",\n consumazioni=[\n"
				+ consumazioni.stream().map(Consumation::getName).collect(Collectors.joining(",\n")) + "\n],\n tavolo="
				+ tavolo + ", numero=" + numero + ", coperti=" + coperti + ",\n getTotale()=" + getTotale() + "\n]";
	}

}

