package br.com.bonuslike.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bonuslike.model.Animal;
import br.com.bonuslike.model.Cliente;
import br.com.bonuslike.model.Cliente_AnimalDTO;
import br.com.bonuslike.service.AnimalService;
import br.com.bonuslike.service.ClienteService;
import br.com.bonuslike.service.DadosService;

@RestController
@RequestMapping("/dadosCliente")
public class DadosResource {
	
	
	@Autowired
	private ClienteService clienteService; 
	

	@Autowired
	private DadosService dadosService; 
	
	@Autowired
	private AnimalService animalService;
	
	List<Cliente> listaCliente = new ArrayList<Cliente>(); 
	

	
	@RequestMapping( method = RequestMethod.POST,  value = "/gravaCliente",  produces = "application/json")
	@CrossOrigin
	public void gravarCliente(@RequestBody Cliente cliente) {
    	
		listaCliente.add(cliente);
		
	} 
	
	
	@RequestMapping( method = RequestMethod.POST,  value = "/gravaAnimal",  produces = "application/json")
	@CrossOrigin
	public void gravarAnimal(@RequestBody List<Animal> listaAnimal) {
    	
		
	  Cliente cliente = new Cliente();
		
	  for(Cliente c : listaCliente) {
    		
		  
		  cliente.setNmcliente(c.getNmcliente());
		  cliente.setDtnasc(c.getDtnasc());
		  cliente.setEmail(c.getEmail());
		  cliente.setWhatsapp(c.getWhatsapp());
		  cliente.setCep(c.getCep());
		  cliente.setCpf(c.getCpf());
		 
    	}
	  
	   long idCliente = clienteService.gravar(cliente);
	   
	   animalService.cadastrarAnimal(listaAnimal, idCliente);
	  
	} 
	
	
	
	@RequestMapping( method = RequestMethod.PUT,  value = "/atualizaCliente",  produces = "application/json")
	@CrossOrigin
	public void atualizarCliente(@RequestBody Cliente cliente) {
    	
		listaCliente.add(cliente);
		
	} 
	
	

	
	@RequestMapping( method = RequestMethod.PUT,  value = "/atualizaAnimal",  produces = "application/json")
	@CrossOrigin
	public void atualizarAnimal(@RequestBody List<Animal> listaAnimal) {
    	
		
	  Cliente cliente = new Cliente();
		
	  for(Cliente c : listaCliente) {
    		
		  
		  cliente.setNmcliente(c.getNmcliente());
		  cliente.setDtnasc(c.getDtnasc());
		  cliente.setEmail(c.getEmail());
		  cliente.setWhatsapp(c.getWhatsapp());
		  cliente.setCep(c.getCep());
		  cliente.setCpf(c.getCpf());
		  cliente.setIdcliente(c.getIdcliente());
		 
    	}
	  
	   clienteService.atualizar(cliente);
	   
	   animalService.atualizarAnimal(listaAnimal, cliente.getIdcliente());
	  
	} 
	
	
	@GetMapping("/buscaCliente/{busca}")
	@CrossOrigin
	public List<Cliente_AnimalDTO> buscarCliente(@PathVariable String busca) {
    	
		return dadosService.buscarDados(busca);
		
	} 
	
	
	@DeleteMapping("/removerCliente/{id}")
	@CrossOrigin
	public void removerCliente(@PathVariable Long id) {
    	
		dadosService.removerCliente(id);
		
	} 
	
	
	@GetMapping("/obterCliente/{id}")
	@CrossOrigin
	public Cliente obterCliente(@PathVariable Long id) {
    	
		return dadosService.obterDadosCliente(id);
		
	} 
	
	
	@GetMapping("/obterAnimal/{id}")
	@CrossOrigin
	public List<Animal> obterAnimal(@PathVariable Long id) {
    	
		return dadosService.obterDadosAnimal(id);
		
	} 
	
	
	
}
