package br.com.fiap.gs.assembler;

import static br.com.fiap.gs.utils.MessagesConstants.METHOD_NOT_IMPLEMENTED;

import org.springframework.stereotype.Component;

import br.com.fiap.gs.dtos.DadosCampoDTO;
import br.com.fiap.gs.model.DadosCampo;

@Component
public class DadosCampoAssemblerMapper implements AssemblerMapper<DadosCampoDTO, DadosCampo>{

	@Override
	public DadosCampoDTO toResource(DadosCampo model) {
		throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public DadosCampo toModel(DadosCampoDTO resource) {
		return DadosCampo.builder()
				.dataEHora(resource.getDataEHora())
				.direcao(resource.getDirecao())
				.identificacaoDrone(resource.getIdentificacaoDrone())
				.lagitude(resource.getLagitude())
				.longitude(resource.getLongitude())
				.velocidade(resource.getVelocidade())
				.build();
	}

}
