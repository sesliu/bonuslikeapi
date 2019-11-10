package br.com.bonuslike.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors
@ToString
@Getter
@Setter
public class Cupom_UtilizacaoDTO {
	
	
	private String dthrbaixa;
    private long nrnf;
    private String identfunc;
    private Long idcampanha;
    private Long idcliente;
    private Long idestabelecimento;
    private String codproduto;
    private String codcupom;

}
