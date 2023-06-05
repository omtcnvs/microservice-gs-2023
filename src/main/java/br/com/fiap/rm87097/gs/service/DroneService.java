package br.com.fiap.rm87097.gs.service;

import static br.com.fiap.rm87097.gs.mockup.DroneMockup.add;
import static br.com.fiap.rm87097.gs.mockup.DroneMockup.findSourceByIdentificacao;
import static br.com.fiap.rm87097.gs.utils.validations.EntityValidations.validateIfEntityAlreadyExistsInDB;
import static br.com.fiap.rm87097.gs.utils.validations.EntityValidations.validateIfEntityDidNotExistsInDB;
import static java.util.Objects.isNull;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.rm87097.gs.assembler.DroneAssemblerMapper;
import br.com.fiap.rm87097.gs.mockup.DroneMockup;
import br.com.fiap.rm87097.gs.model.Drone;
import br.com.fiap.rm87097.gs.resources.DroneResource;
import br.com.fiap.rm87097.gs.resources.PutDroneResource;

@Service
public class DroneService {

	@Autowired
	private DroneAssemblerMapper assembler;
	
	public void save(@Valid DroneResource resource) {
		validateIfEntityAlreadyExistsInDB(resource.getIdentificacao());
		add(assembler.toModel(resource));
	}

	public Drone findByIdentificacao(String identificacao) {
		validateIfEntityDidNotExistsInDB(identificacao);
		return findSourceByIdentificacao(identificacao);
	}

	public Drone putDrone(String identificacao, @Valid PutDroneResource resource) {
		validateIfEntityDidNotExistsInDB(identificacao);
		validateIfEntityAlreadyExistsInDB(resource.getIdentificacao());
		return updateEntityFields(identificacao, resource);
	}

	private Drone updateEntityFields(String identificacao, PutDroneResource resource) {
		Drone modelToUpdate = findSourceByIdentificacao(identificacao);
		modelToUpdate.setCapacidadeBateria(isNull(resource.getCapacidadeBateria()) ?  modelToUpdate.getCapacidadeBateria() : resource.getCapacidadeBateria());
		modelToUpdate.setCapacidadeCarga(isNull(resource.getCapacidadeCarga()) ?  modelToUpdate.getCapacidadeCarga() : resource.getCapacidadeCarga());
		modelToUpdate.setHistoricoVoo(isNull(resource.getHistoricoVoo()) ?  modelToUpdate.getHistoricoVoo() : resource.getHistoricoVoo());
		modelToUpdate.setHorasDeVoo(isNull(resource.getHorasDeVoo()) ?  modelToUpdate.getHorasDeVoo() : resource.getHorasDeVoo());
		modelToUpdate.setIdentificacao(isNull(resource.getIdentificacao()) ?  modelToUpdate.getIdentificacao() : resource.getIdentificacao());
		modelToUpdate.setLicencaVoo(isNull(resource.getLicencaVoo()) ?  modelToUpdate.getLicencaVoo() : resource.getLicencaVoo());
		modelToUpdate.setNumeroSerie(isNull(resource.getNumeroSerie()) ?  modelToUpdate.getNumeroSerie() : resource.getNumeroSerie());
		modelToUpdate.setModelo(isNull(resource.getModelo()) ?  modelToUpdate.getModelo() : resource.getModelo());
		return modelToUpdate;
	}

	public List<Drone> getAll() {
		return DroneMockup.getAll();
	}

	public void deleteByIdentificacao(String identificacao) {
		Drone modelToDelete = DroneMockup.findSourceByIdentificacao(identificacao);
		DroneMockup.delete(modelToDelete);
	}
	
}

