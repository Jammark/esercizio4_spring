package com.esercizio4spring.esercizio4_srping.model;

public class ToppingDecorator extends IngredienteDecorator {

	public ToppingDecorator(Consumation campo, Ingrediente ingrediente) {
		super(campo, ingrediente);
		if (campo instanceof Pizza p) {
			p.getToppings().add(ingrediente);
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getCampo().getName() + " + " + getIngrediente().getName();
	}
}
