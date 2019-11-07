package br.com.bonuslike.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bonuslike.model.Cliente_AnimalDTO;
import br.com.bonuslike.model.Cliente_CupomDTO;
import br.com.bonuslike.model.Cupom_UtilizacaoDTO;
import br.com.bonuslike.model.Produto;
import br.com.bonuslike.service.CupomService;

@RestController
@RequestMapping("/cupom")
public class CupomResource {

	@Autowired
	private CupomService cupomService;
	
	@GetMapping("/busca/{busca}")
	@CrossOrigin
	public Cliente_CupomDTO buscarCupom(@PathVariable String busca){ 
		
		
		return cupomService.buscarCupom(busca); 
	}
	
	
	
	@GetMapping("/cliente/{cupom}")
	@CrossOrigin
	public List<Cliente_AnimalDTO> buscarClienteCupom(@PathVariable String cupom){ 
		
		
		return cupomService.buscarClienteCupom(cupom); 
	}
	
	
	
	@GetMapping("/produto/{cupom}")
	@CrossOrigin
	public List<Produto> buscarProdutoeCupom(@PathVariable String cupom){ 
		
		
		return cupomService.buscarProsutoCupom(cupom); 
	}
	
	
	@RequestMapping( method = RequestMethod.POST,  value = "/gravaUtilizacao",  produces = "application/json")
	@CrossOrigin
	public void buscarClienteCupom(@RequestBody Cupom_UtilizacaoDTO cupom){ 
		
		cupomService.gravarCupomUtlizado(cupom);
		
	}
	
	
}
