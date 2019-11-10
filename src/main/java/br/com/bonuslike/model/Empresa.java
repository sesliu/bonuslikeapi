package br.com.bonuslike.model;

import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors
@ToString
public class Empresa {
	
	private Long idempresa;
    private String nmempresa;
    private String cnpj;
    private Long idtipoempresa;

}
