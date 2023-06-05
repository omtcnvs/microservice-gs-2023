package br.com.fiap.gs.model;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LicencaVoo {

	private Long numeroLicenca;
	
	private LocalDateTime dataEmissao;
	
	private Boolean validade;
	
	@Override
	public String toString() {
		return reflectionToString(this);
	}

}
