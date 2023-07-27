package com.esercizio4spring.esercizio4_srping.data;

import com.esercizio4spring.esercizio4_srping.model.Ordine;

public interface IOrdineDAO {

	public void save(Ordine o);

	public Ordine findById(Long id);

	public void findByIdAndUpdate(Long id, Ordine o);

	public boolean present(Ordine o);

}
