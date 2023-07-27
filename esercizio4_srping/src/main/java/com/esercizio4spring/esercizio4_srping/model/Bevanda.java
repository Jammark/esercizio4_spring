package com.esercizio4spring.esercizio4_srping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bevande")
@Setter
@Getter
@NoArgsConstructor
public class Bevanda extends Consumation {

	@Id
	@GeneratedValue
	private Long id;
	private double price;

	public Bevanda(String name, double price) {
		super(name);
		this.price = price;
	}

	@Override
	public double getPrice() {

		return this.price;
	}

	@Override
	public String toString() {
		return "Bevanda [price=" + price + ", getName()=" + getName() + "]";
	}

}
