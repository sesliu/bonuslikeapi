package br.com.bonuslike.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors
@ToString
@Getter
@Setter
public class Campanha {
	
	
	private String nmcampanha;
    private String dtvalidade;
    private Long idcampanha;
    private Long idempresa;
    private String descricao;
    private String imagem;
    private String flativo;
    private String tag;
    private Integer desconto;

}
