package br.com.bonuslike.repository;

import java.util.List;

import br.com.bonuslike.model.Cliente_AnimalDTO;
import br.com.bonuslike.model.Cliente_CupomDTO;
import br.com.bonuslike.model.Cupom_UtilizacaoDTO;
import br.com.bonuslike.model.Produto;

public interface ICupomRepository {
		
	Cliente_CupomDTO buscarCupom(String buscar);
	
	List<Cliente_AnimalDTO> buscarClienteCupom(String cupom);
	
	List<Produto> buscarProsutoCupom(String cupom);
	
	void gravarCupomUtlizado(Cupom_UtilizacaoDTO cupom);

}
