package br.com.fiap.gs.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DadosCampo {

	private String identificacaoDrone;
	
	private Long longitude;

	private Long lagitude;

	private Integer velocidade;

	private Double direcao;

	private LocalDateTime dataEHora;

	@Override
	public String toString() {
		return reflectionToString(this);
	}

}
