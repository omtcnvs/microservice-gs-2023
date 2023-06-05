package br.com.fiap.gs.dtos;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
public class DroneDTO {

	@NotBlank(message = "Identificacao deve ser informada.")
	private String identificacao;
	
	@NotBlank(message = "Modelo deve ser informado.")
	private String modelo;
	
	@NotNull(message = "Numero de série deve ser informado.")
	private Long numeroSerie;
	
	@NotNull(message = "Licença de voo deve ser informada.")
	@Valid
	private LicencaVooDTO licencaVoo;
	
	@NotNull(message = "Capacidade da bateria deve ser informada.")
	private Integer capacidadeBateria;
	
	@NotNull(message = "Capacidade de carga deve ser informada.")
	private Integer capacidadeCarga;
	
	@Override
	public String toString() {
		return reflectionToString(this);
	}
	
}
