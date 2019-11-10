package br.com.bonuslike.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bonuslike.model.Cliente_AnimalDTO;
import br.com.bonuslike.model.Cliente_CupomDTO;
import br.com.bonuslike.model.Cupom_UtilizacaoDTO;
import br.com.bonuslike.model.Produto;
import br.com.bonuslike.repository.CupomRepository;

@Service
public class CupomService implements ICupomService{
	
	
	@Autowired
	private CupomRepository cupomRepository;

	@Override
	public Cliente_CupomDTO buscarCupom(String busca) {
		
		return cupomRepository.buscarCupom(busca);
	}

	@Override
	public List<Cliente_AnimalDTO> buscarClienteCupom(String cupom) {
		
		return cupomRepository.buscarClienteCupom(cupom);
	}

	@Override
	public List<Produto> buscarProsutoCupom(String cupom) {
		
		return cupomRepository.buscarProsutoCupom(cupom);
	}

	@Override
	public void gravarCupomUtlizado(Cupom_UtilizacaoDTO cupom) {
		
		cupomRepository.gravarCupomUtlizado(cupom);
		
	}

}
