package br.com.fiap.gs.assembler;

import static br.com.fiap.gs.utils.MessagesConstants.METHOD_NOT_IMPLEMENTED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.gs.dtos.DroneDTO;
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

}
