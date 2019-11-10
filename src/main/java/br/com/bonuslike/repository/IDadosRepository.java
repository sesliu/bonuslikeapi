package br.com.bonuslike.repository;

import java.util.List;

import br.com.bonuslike.model.Animal;
import br.com.bonuslike.model.Cliente;
import br.com.bonuslike.model.Cliente_AnimalDTO;

public interface IDadosRepository {
	
	List<Cliente_AnimalDTO> buscarDados(String buscar);
	Cliente obterDadosCliente(Long id);
	List<Animal> obterDadosAnimal(Long id);

}
