package br.com.fiap.gs.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.List;

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
	
	private List<DadosHistoricoVoo> historicoVoo;
	
	@Override
	public String toString() {
		return reflectionToString(this);
	}

}
