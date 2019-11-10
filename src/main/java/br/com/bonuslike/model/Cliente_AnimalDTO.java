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
public class Cliente_AnimalDTO {

	private Cliente cliente;
	private Animal animal;
	
}
