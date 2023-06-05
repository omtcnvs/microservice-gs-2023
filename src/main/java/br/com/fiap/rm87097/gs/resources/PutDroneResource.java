package br.com.fiap.rm87097.gs.resources;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.List;

import br.com.fiap.rm87097.gs.model.DadosHistoricoVoo;
import br.com.fiap.rm87097.gs.model.LicencaVoo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutDroneResource {

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
