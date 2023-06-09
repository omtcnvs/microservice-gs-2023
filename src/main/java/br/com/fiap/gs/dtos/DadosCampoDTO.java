package br.com.fiap.gs.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DadosCampoDTO {
	
	@NotBlank(message = "A identificação do drone deve ser informada.")
	private String identificacaoDrone;
	
	@NotNull(message = "A longitude do campo deve ser informada.")
	private Long longitude;
	
	@NotNull(message = "A lagitude do campo deve ser informada.")
	private Long lagitude;

	@NotNull(message = "A velocidade do drone durante a trajetória deve ser informada.")
	private Integer velocidade;

	@NotNull(message = "A direção do percurso deve ser informada.")
	private Double direcao;

	@NotNull(message = "A data e hora do voo deve ser informada.")
	private LocalDateTime dataEHora;

}
