package br.com.fiap.rm87097.gs.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Drone {

	@EqualsAndHashCode.Include
	private String identificacao;
	
	private String modelo;
	
	private Long numeroSerie;
	
	private LicencaVoo licencaVoo;
	
	private Integer capacidadeBateria;
	
	private Integer capacidadeCarga;
	
	private Integer horasDeVoo;
	
	private HistoricoVoo historicoVoo;
	
	@Override
	public String toString() {
		return reflectionToString(this);
	}

}
