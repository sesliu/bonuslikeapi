package br.com.bonuslike.service;

import br.com.bonuslike.model.Cliente;

public interface IClienteService {
	
	
	long gravar(Cliente cliente);
	void atualizar(Cliente cliente);

}
