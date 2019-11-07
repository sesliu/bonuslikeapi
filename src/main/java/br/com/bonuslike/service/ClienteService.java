package br.com.bonuslike.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bonuslike.model.Cliente;
import br.com.bonuslike.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	
	
	
	@Override
	public long gravar(Cliente cliente) {
		
		String dataFormatada = cliente.getDtnasc();
		
		dataFormatada = dataFormatada.substring(6)+"-"+dataFormatada.substring(3,5)+"-"+dataFormatada.substring(0,2);
		cliente.setDtnasc(dataFormatada);
		
		return clienteRepository.gravar(cliente);
	}




	@Override
	public void atualizar(Cliente cliente) {
		
	    String dataFormatada = cliente.getDtnasc();
		
		dataFormatada = dataFormatada.substring(6)+"-"+dataFormatada.substring(3,5)+"-"+dataFormatada.substring(0,2);
		cliente.setDtnasc(dataFormatada);
		
		clienteRepository.atualizar(cliente);
	
	}

}
