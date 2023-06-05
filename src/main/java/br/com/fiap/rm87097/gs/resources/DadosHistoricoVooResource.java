package br.com.fiap.rm87097.gs.resources;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.time.LocalDateTime;
import java.time.LocalTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DadosHistoricoVooResource {

	private LocalDateTime data;
	
	private LocalTime horario;
	
	private Integer duracaoVoo;
	
	private Long coordenadasInicioVoo;
	
	private Long coordenadasFimBVoo;
	
	private Integer altura;
	
	private Integer velocidadeMedia;
	
	@Override
	public String toString() {
		return reflectionToString(this);
	}

}
