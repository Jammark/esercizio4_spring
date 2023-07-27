package com.esercizio4spring.esercizio4_srping.data;

import com.esercizio4spring.esercizio4_srping.model.Consumation;

public interface IConsumationDAO {

	public void save(Consumation c);

	public Consumation findById(Long id);

	public void findByIdAndUpdate(Long id, Consumation c);

}
