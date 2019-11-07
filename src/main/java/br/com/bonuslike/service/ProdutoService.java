package br.com.bonuslike.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bonuslike.model.Produto_CampanhaDTO;
import br.com.bonuslike.repository.ProdutoRepository;

@Service
public class ProdutoService implements IProdutoService{
	
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public void registrarQuantidade(Produto_CampanhaDTO produto) {
		
		produtoRepository.registrarQuantidade(produto);
		
	}

}
