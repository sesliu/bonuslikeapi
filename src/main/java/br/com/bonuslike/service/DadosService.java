package br.com.bonuslike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bonuslike.model.Animal;
import br.com.bonuslike.model.Cliente;
import br.com.bonuslike.model.Cliente_AnimalDTO;
import br.com.bonuslike.repository.AnimalRepository;
import br.com.bonuslike.repository.ClienteRepository;
import br.com.bonuslike.repository.DadosRepository;


@Service
public class DadosService implements IDadosService{
	


@Autowired
private DadosRepository dadosRepository;


@Autowired
private AnimalRepository animalRepository;


@Autowired
private ClienteRepository clienteRepository;



	@Override
	public List<Cliente_AnimalDTO> buscarDados(String buscar) {
		
		return dadosRepository.buscarDados(buscar);
	}


	@Override
	public Cliente obterDadosCliente(Long id) {
		
		return dadosRepository.obterDadosCliente(id);
	}


	@Override
	public List<Animal> obterDadosAnimal(Long id) {
		return dadosRepository.obterDadosAnimal(id);
	}


	@Override
	public void removerCliente(Long id) {
		
		animalRepository.remover(id);
		clienteRepository.remover(id);
		
	}

}
