package br.com.bonuslike.repository;

import br.com.bonuslike.model.Produto_CampanhaDTO;

public interface IProdutoRepository {
	
	
	void registrarQuantidade(Produto_CampanhaDTO produto);

}
