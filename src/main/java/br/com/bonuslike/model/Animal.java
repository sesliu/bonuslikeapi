package br.com.bonuslike.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors
@ToString
@Getter
@Setter
public class Animal {
	
	
	private String nmanimal;
    private String dtnasc;
    private String raca;
    private Long idanimal;
    private String tipo;
    private String sexo;
    private Long idcliente;
 

}
