package com.esercizio4spring.esercizio4_srping.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esercizio4spring.esercizio4_srping.model.Consumation;

@Service
public class ConsumationService implements IConsumationDAO {

	@Autowired
	private ConsumationRepository repo;

	@Override
	public void save(Consumation c) {
		repo.save(c);

	}

	@Override
	public Consumation findById(Long id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public void findByIdAndUpdate(Long id, Consumation c) {
		// TODO Auto-generated method stub

	}

}
