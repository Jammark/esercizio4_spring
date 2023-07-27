package com.esercizio4spring.esercizio4_srping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.esercizio4spring.esercizio4_srping.model.Bevanda;
import com.esercizio4spring.esercizio4_srping.model.Consumation;
import com.esercizio4spring.esercizio4_srping.model.Ingrediente;
import com.esercizio4spring.esercizio4_srping.model.IngredienteDecorator;
import com.esercizio4spring.esercizio4_srping.model.Pizza;
import com.esercizio4spring.esercizio4_srping.model.PizzaDecorator;
import com.esercizio4spring.esercizio4_srping.model.ToppingDecorator;

import lombok.Setter;

@Configuration
@PropertySource("classpath:application.properties")
@Setter
//@Scope("singleton")

public class AppConfig {

	private static int tavoliCount = 0, ordiniCount = 1;

	private static Map<Integer, List<Consumation>> nextConsumations = new HashMap<Integer, List<Consumation>>();

	public void init() {


		nextConsumations.put(1,
				new ArrayList<Consumation>(Arrays.asList(
						new ToppingDecorator((PizzaDecorator) this.getDiavola(), (Ingrediente) getMais()),
						(PizzaDecorator) getCottoEFunghi(), (Bevanda) getBirra())));
		nextConsumations.put(2,
				new ArrayList<Consumation>(Arrays.asList(
						new ToppingDecorator((PizzaDecorator) getHawaiana(), (Ingrediente) getSalame()),
						(PizzaDecorator) getMaisECotto(), (Bevanda) getCola())));
	}

	@Value("${pomodoro}")
	private double prezzoPomodoro;

	@Value("${mozzarella}")
	private double prezzoMozzarella;

	@Value("${ananas}")
	private double prezzoAnanas;

	@Value("${prosciutto}")
	private double prezzoProsciutto;

	@Value("${funghi}")
	private double prezzoFunghi;

	@Value("${salame}")
	private double prezzoSalame;

	@Value("${mais}")
	private double prezzoMais;

	@Value("${acqua}")
	private double prezzoAcqua;

	@Value("${cola}")
	private double prezzoCola;

	@Value("${birra}")
	private double prezzoBirra;

	@Bean
	public Ingrediente getPomodoro() {
		return new Ingrediente("Pomodoro", this.prezzoPomodoro, 100);
	}

	@Bean
	public Ingrediente getMozzarella() {
		return new Ingrediente("Mozzarella", this.prezzoMozzarella, 140);
	}

	@Bean
	public Ingrediente getAnanas() {
		return new Ingrediente("Ananas", this.prezzoAnanas, 200);
	}

	@Bean
	public Ingrediente getProsciutto() {
		return new Ingrediente("Prosciutto cotto", this.prezzoProsciutto, 300);
	}

	@Bean
	public Ingrediente getFunghi() {
		return new Ingrediente("funghi", this.prezzoFunghi, 400);
	}

	@Bean
	public Ingrediente getMais() {
		return new Ingrediente("mais", this.prezzoMais, 400);
	}

	@Bean
	public Ingrediente getSalame() {
		return new Ingrediente("salame piccante", this.prezzoSalame, 500);
	}

	@Bean
	public Bevanda getCola() {
		return new Bevanda("Pepsi", this.prezzoCola);
	}

	@Bean
	public Bevanda getAcqua() {
		return new Bevanda("Acqua Minerale", this.prezzoAcqua);
	}

	@Bean
	public Bevanda getBirra() {
		return new Bevanda("Heineken", this.prezzoBirra);
	}

	@Bean
	@Scope("prototype")
	public Consumation getHawaiana() {
		return new IngredienteDecorator(new IngredienteDecorator(new IngredienteDecorator(
				new IngredienteDecorator(new Pizza("Hawaiana", 1200), getAnanas()), getProsciutto()), getPomodoro()),
				getMozzarella());
	}

	@Bean
	@Scope("prototype")
	public Consumation getCottoEFunghi() {
		return new IngredienteDecorator(new IngredienteDecorator(
				new IngredienteDecorator(new IngredienteDecorator(new Pizza("Cotto e funghi", 900), getFunghi()),
						getProsciutto()),
				getPomodoro()), getMozzarella());

	}

	@Bean
	@Scope("prototype")
	public Consumation getDiavola() {
		return

		new IngredienteDecorator(new IngredienteDecorator(
				new IngredienteDecorator(new Pizza("Diavola", 1100), getSalame()), getPomodoro()), getMozzarella());

	}

	@Bean
	@Scope("prototype")
	public Consumation getMaisECotto() {
		return new IngredienteDecorator(new IngredienteDecorator(new IngredienteDecorator(
				new IngredienteDecorator(new Pizza("Mais e cotto", 800), getMais()), getProsciutto()), getPomodoro()),
				getMozzarella());

	}

	@Bean
	public int getNumeroTavolo() {
		return ++tavoliCount;
	}

	@Bean
	public int getNumeroOrdine() {
		return ordiniCount++;
	}

	@Bean
	public LocalDate getAcquisizione() {
		return LocalDate.now();
	}



	@Bean
	public int getCoperti() {
		return new Random().nextInt(1, 7);
	}

	@Bean
	public List<Consumation> getNextConsimations() {
		if (nextConsumations.isEmpty()) {
			this.init();
		}
		List<Consumation> lista = nextConsumations.get(ordiniCount);
		if (lista != null) {
			return lista;
		} else {
			return Collections.EMPTY_LIST;
		}
	}
}
