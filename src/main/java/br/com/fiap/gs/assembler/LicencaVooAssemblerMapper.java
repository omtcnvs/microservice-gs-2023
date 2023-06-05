package br.com.fiap.gs.assembler;

import static br.com.fiap.gs.utils.MessagesConstants.METHOD_NOT_IMPLEMENTED;

import org.springframework.stereotype.Component;

import br.com.fiap.gs.dtos.LicencaVooDTO;
import br.com.fiap.gs.model.LicencaVoo;

@Component
public class LicencaVooAssemblerMapper implements AssemblerMapper<LicencaVooDTO, LicencaVoo>{

	@Override
	public LicencaVooDTO toResource(LicencaVoo model) {
		throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public LicencaVoo toModel(LicencaVooDTO resource) {
		return LicencaVoo.builder()
				.dataEmissao(resource.getDataEmissao())
				.numeroLicenca(resource.getNumeroLicenca())
				.validade(resource.getValidade())
				.build();
	}

	
	
}
