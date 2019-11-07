package br.com.bonuslike.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors
@ToString
@Getter
@Setter
public class Cupom {
	
	private String codcupom;
    private String dthrgeracao;
    private String codproduto;
    private Long idcampanha;
    private Long idcliente;
    private String dthrbaixa;
    private Double valor;
    private Long idestabelecimento;

}
