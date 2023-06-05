package br.com.fiap.gs.dtos;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DadosCampoDTO {
	
	private String identificacaoDrone;
	
	private Long longitude;

	private Long lagitude;

	private Integer velocidade;

	private Double direcao;

	private LocalDateTime dataEHora;

}
