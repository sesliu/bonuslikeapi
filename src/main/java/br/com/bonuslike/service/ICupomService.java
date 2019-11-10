package br.com.bonuslike.service;

import java.util.List;

import br.com.bonuslike.model.Cliente_AnimalDTO;
import br.com.bonuslike.model.Cliente_CupomDTO;
import br.com.bonuslike.model.Cupom_UtilizacaoDTO;
import br.com.bonuslike.model.Produto;

public interface ICupomService {
	
	
	
	Cliente_CupomDTO buscarCupom(String busca);
	
	List<Cliente_AnimalDTO> buscarClienteCupom(String cupom);
	
	List<Produto> buscarProsutoCupom(String cupom);
	
	void gravarCupomUtlizado(Cupom_UtilizacaoDTO cupom);

}
