package br.com.bonuslike.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors
@ToString
@Setter
@Getter
@Component
public class Cliente_CupomDTO {
	
	private Cliente cliente;
	private Cupom cumpom;
	private Produto produto;
	private Campanha campanha;
	

}
