package br.com.fiap.gs.assembler;

import static br.com.fiap.gs.utils.MessagesConstants.METHOD_NOT_IMPLEMENTED;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.gs.dtos.DadosHistoricoVooDTO;
import br.com.fiap.gs.dtos.DroneDTO;
import br.com.fiap.gs.model.DadosHistoricoVoo;
import br.com.fiap.gs.model.Drone;
import br.com.fiap.gs.model.LicencaVoo;

@Component
public class DroneAssemblerMapper implements AssemblerMapper<DroneDTO, Drone>{

	@Autowired
	private LicencaVooAssemblerMapper licencaAssembler;
	
	@Override
	public DroneDTO toResource(Drone model) {
		throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public Drone toModel(DroneDTO resource) {
		return Drone.builder()
				.identificacao(resource.getIdentificacao())
				.modelo(resource.getModelo())
				.numeroSerie(resource.getNumeroSerie())
				.licencaVoo(buildLicencaVoo(resource))
				.capacidadeBateria(resource.getCapacidadeBateria())
				.capacidadeCarga(resource.getCapacidadeCarga())
				.build();
	}

	private LicencaVoo buildLicencaVoo(DroneDTO resource) {
		return licencaAssembler.toModel(resource.getLicencaVoo());
	}

	public List<DadosHistoricoVoo> historicoVooParse(List<DadosHistoricoVooDTO> historicoVoo) {
		List<DadosHistoricoVoo> dadosHistoricoData = new ArrayList<>();
		historicoVoo.forEach(resource -> {
			dadosHistoricoData.add(DadosHistoricoVoo.builder()
					.altura(resource.getAltura())
					.coordenadasFimVoo(resource.getCoordenadasFimVoo())
					.coordenadasInicioVoo(resource.getCoordenadasInicioVoo())
					.dataEHora(resource.getDataEHora())
					.duracaoVoo(resource.getDuracaoVoo())
					.velocidadeMedia(resource.getVelocidadeMedia())
					.build());
		});;
		return dadosHistoricoData;
	}

}
