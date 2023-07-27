package com.esercizio4spring.esercizio4_srping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "ingredienti")
@NoArgsConstructor
@ToString
public class Ingrediente extends Consumation {

	private double price;
	private int calorie;

	public Ingrediente(String name, double price, int calorie) {
		super(name);
		this.price = price;
		this.calorie = calorie;

	}

	@Override
	public double getPrice() {
		return this.price;
	}

}
