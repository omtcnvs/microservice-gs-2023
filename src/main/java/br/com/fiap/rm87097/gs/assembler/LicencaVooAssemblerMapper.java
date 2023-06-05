package br.com.fiap.rm87097.gs.assembler;

import static br.com.fiap.rm87097.gs.utils.MessagesConstants.METHOD_NOT_IMPLEMENTED;

import org.springframework.stereotype.Component;

import br.com.fiap.rm87097.gs.model.LicencaVoo;
import br.com.fiap.rm87097.gs.resources.LicencaVooResource;

@Component
public class LicencaVooAssemblerMapper implements AssemblerMapper<LicencaVooResource, LicencaVoo>{

	@Override
	public LicencaVooResource toResource(LicencaVoo model) {
		throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public LicencaVoo toModel(LicencaVooResource resource) {
		return LicencaVoo.builder()
				.dataEmissao(resource.getDataEmissao())
				.numeroLicenca(resource.getNumeroLicenca())
				.validade(resource.getValidade())
				.build();
	}

	
	
}
