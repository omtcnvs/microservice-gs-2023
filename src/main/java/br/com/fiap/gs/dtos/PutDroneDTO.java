package br.com.fiap.gs.dtos;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.util.List;

import br.com.fiap.gs.model.LicencaVoo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PutDroneDTO {

	private String identificacao;
	
	private String modelo;
	
	private Long numeroSerie;
	
	private LicencaVoo licencaVoo;
	
	private Integer capacidadeBateria;
	
	private Integer capacidadeCarga;
	
	private Integer horasDeVoo;
	
	private List<DadosHistoricoVooDTO> historicoVoo;
	
	@Override
	public String toString() {
		return reflectionToString(this);
	}
	
}
