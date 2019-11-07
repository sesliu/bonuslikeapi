package br.com.bonuslike.model;

import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors
@ToString
public class Estabelecimento {
	
	private String nmestabelecimento;
    private String dtcriacao;
    private Long idestabelecimento;
    private Long idempresa;

}
