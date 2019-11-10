package br.com.bonuslike.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors
@ToString
@Getter
@Setter
public class Cliente {

	
	private String nmcliente;
    private String cpf;
    private String email;
    private String whatsapp;
    private String cep;
    private String dtnasc;
    private Long idcliente;
	
}
