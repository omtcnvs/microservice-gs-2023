package br.com.fiap.gs.dtos;

import static org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString;

import java.time.LocalDateTime;

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
public class LicencaVooDTO {

	private Long numeroLicenca;

	private LocalDateTime dataEmissao;

	private Boolean validade;

	@Override
	public String toString() {
		return reflectionToString(this);
	}

}
