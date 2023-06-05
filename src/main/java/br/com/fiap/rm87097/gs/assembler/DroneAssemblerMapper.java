package br.com.fiap.rm87097.gs.assembler;

import static br.com.fiap.rm87097.gs.utils.MessagesConstants.METHOD_NOT_IMPLEMENTED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.rm87097.gs.model.Drone;
import br.com.fiap.rm87097.gs.model.LicencaVoo;
import br.com.fiap.rm87097.gs.resources.DroneResource;

@Component
public class DroneAssemblerMapper implements AssemblerMapper<DroneResource, Drone>{

	@Autowired
	private LicencaVooAssemblerMapper licencaAssembler;
	
	@Override
	public DroneResource toResource(Drone model) {
		throw new UnsupportedOperationException(METHOD_NOT_IMPLEMENTED);
	}

	@Override
	public Drone toModel(DroneResource resource) {
		return Drone.builder()
				.identificacao(resource.getIdentificacao())
				.modelo(resource.getModelo())
				.numeroSerie(resource.getNumeroSerie())
				.licencaVoo(buildLicencaVoo(resource))
				.capacidadeBateria(resource.getCapacidadeBateria())
				.capacidadeCarga(resource.getCapacidadeCarga())
				.build();
	}

	private LicencaVoo buildLicencaVoo(DroneResource resource) {
		return licencaAssembler.toModel(resource.getLicencaVoo());
	}

}
