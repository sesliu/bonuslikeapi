package br.com.bonuslike.resource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.bonuslike.model.Produto_CampanhaDTO;
import br.com.bonuslike.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
	
	
	@Autowired
	private ProdutoService produtoService; 
	
	
	
	
	@RequestMapping( method = RequestMethod.PUT,  value = "/registro",  produces = "application/json")
	@CrossOrigin
	public void buscarClienteCupom(@RequestBody Produto_CampanhaDTO produto){ 
		
		produtoService.registrarQuantidade(produto);
		
	}

}
