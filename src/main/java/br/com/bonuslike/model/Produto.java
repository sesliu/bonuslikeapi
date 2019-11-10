package br.com.bonuslike.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors
@ToString
@Getter
@Setter
public class Produto {
	
	 private String codproduto;
	 private String descricao;
	 private Long idtipoproduto;
	 private Integer qtdproduto;

	

}
