package br.com.bonuslike.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bonuslike.model.Animal;
import br.com.bonuslike.repository.AnimalRepository;



@Service
public class AnimalService implements IAnimalService{
	

@Autowired
private AnimalRepository animalRepository;


	private void gravar(Animal animal, long idCliente) {
		
		animalRepository.gravar(animal, idCliente);
		
	}
	

	private void atualizar(Animal animal, long idCliente) {
		
		animalRepository.gravar(animal, idCliente);
	}

	@Override
	public void cadastrarAnimal(List<Animal> listaAnimal, long idCliente) {
	
		for(Animal a : listaAnimal) {
			
			String dataFormatada = a.getDtnasc();
			dataFormatada = dataFormatada.substring(6)+"-"+dataFormatada.substring(3,5)+"-"+dataFormatada.substring(0,2);
			a.setDtnasc(dataFormatada);
			
			gravar(a,idCliente);
		}
	}

	@Override
	public void atualizarAnimal(List<Animal> listaAnimal, long idCliente) {
		

		animalRepository.remover(idCliente);
		
		for(Animal a : listaAnimal) {
			
			String dataFormatada = a.getDtnasc();
			dataFormatada = dataFormatada.substring(6)+"-"+dataFormatada.substring(3,5)+"-"+dataFormatada.substring(0,2);
			a.setDtnasc(dataFormatada);
			
			atualizar(a,idCliente);
		}
		
	}
	
	
	

}
