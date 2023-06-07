package br.com.fiap.gs.dtos;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DadosHistoricoVooDTO {

	private LocalDateTime dataEHora;
	
	
	private Integer duracaoVoo;
	
	private Long coordenadasInicioVoo;
	
	private Long coordenadasFimVoo;
	
	private Integer altura;
	
	private Integer velocidadeMedia;
	
	@Override
	public String toString() {
		return reflectionToString(this);
	}

}
