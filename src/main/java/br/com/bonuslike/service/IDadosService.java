package br.com.bonuslike.service;

import java.util.List;

import br.com.bonuslike.model.Animal;
import br.com.bonuslike.model.Cliente;
import br.com.bonuslike.model.Cliente_AnimalDTO;

public interface IDadosService {

	
	List<Cliente_AnimalDTO> buscarDados(String buscar);
	Cliente obterDadosCliente(Long id);
	List<Animal> obterDadosAnimal(Long id);
	void removerCliente(Long id);
}
