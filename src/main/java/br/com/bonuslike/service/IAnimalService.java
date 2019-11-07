package br.com.bonuslike.service;

import java.util.List;

import br.com.bonuslike.model.Animal;

public interface IAnimalService {
	
		
	
	void cadastrarAnimal(List<Animal> listaAnimal, long idCliente);
	
	void atualizarAnimal(List<Animal> listaAnimal, long idCliente);

}
