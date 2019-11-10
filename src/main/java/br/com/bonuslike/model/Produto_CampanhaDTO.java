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
public class Produto_CampanhaDTO {
	
	 private String codproduto;
	 private String descricao;
	 private Long idtipoproduto;
	 private Integer qtdproduto;
	 private Long idcampanha;
	 
	
}
