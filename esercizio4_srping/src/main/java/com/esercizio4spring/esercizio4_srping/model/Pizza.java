package com.esercizio4spring.esercizio4_srping.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "pizze")
@NoArgsConstructor
public class Pizza extends Consumation {

	private int calorie;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pizza_ingredienti", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
	private Set<Ingrediente> ingredienti;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "pizza_toppings", joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
	private Set<Ingrediente> toppings;

	public Pizza(String name, int calorie) {
		super(name);
		this.calorie = calorie;
		this.ingredienti = new HashSet<Ingrediente>();
		this.toppings = new HashSet<Ingrediente>();
	}

	@Override
	public double getPrice() {

		return 5.0;
	}

	@Override
	public String toString() {
		return "Pizza [getName()=" + getName() // + " -Pizza con "
		// +
		// Arrays.asList(this.getCampi()).stream().map(Consumation::getName).collect(Collectors.joining("
		// , "))
				+ "]";
	}

}
