package br.com.bonuslike.repository;


import br.com.bonuslike.model.Cliente;

public interface IClienteRepository {
	

	long gravar(Cliente cliente);
	void atualizar(Cliente cliente);



}
