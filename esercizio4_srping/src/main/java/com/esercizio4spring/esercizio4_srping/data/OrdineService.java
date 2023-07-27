package com.esercizio4spring.esercizio4_srping.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esercizio4spring.esercizio4_srping.model.Ordine;

@Service
public class OrdineService implements IOrdineDAO {

	@Autowired
	private OrdineRepositorry repo;

	@Override
	public void save(Ordine o) {
		repo.save(o);

	}

	@Override
	public Ordine findById(Long id) {

		return repo.findById(id).orElseThrow();
	}

	@Override
	public void findByIdAndUpdate(Long id, Ordine o) {
		Ordine found = repo.findById(id).orElseThrow();
		found.setAcquisizione(o.getAcquisizione());
		found.setCoperti(o.getCoperti());
		found.setConsumazioni(o.getConsumazioni());
		found.setNumero(o.getNumero());
		found.setTavolo(o.getTavolo());
		repo.save(found);

	}

	@Override
	public boolean present(Ordine o) {

		return repo.findByNumero(o.getNumero()).size() > 0;
	}

}
