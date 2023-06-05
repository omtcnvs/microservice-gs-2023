package br.com.fiap.rm87097.gs.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DadosCampo {

	private Long longitude;

	private Long lagitude;

	private Integer velocidade;

	private Double direcao;

	private LocalDateTime tempo;

	@Override
	public String toString() {
		return reflectionToString(this);
	}

}
