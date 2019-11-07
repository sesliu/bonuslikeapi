package br.com.bonuslike.repository;

import br.com.bonuslike.model.Animal;

public interface IAnimalRepository {
	
	
	
	void gravar(Animal animal, long idCliente);
	void atualizar(Animal animal, long idCliente);

}
