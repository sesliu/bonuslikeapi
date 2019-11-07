package br.com.bonuslike.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors
@Getter
@Setter
public class DadosCliente {

	
	private String nmcliente;
    private String cpf;
    private String email;
    private String whatsapp;
    private String cep;
    private String dtnasc;
    private Long idcliente;
	
}
