package br.com.fiap.rm87097.gs.service;

import static br.com.fiap.rm87097.gs.mockup.DroneMockup.add;
import static br.com.fiap.rm87097.gs.mockup.DroneMockup.findSourceByIdentificacao;
import static br.com.fiap.rm87097.gs.utils.validations.EntityValidations.validateIfEntityAlreadyExistsInDB;
import static br.com.fiap.rm87097.gs.utils.validations.EntityValidations.validateIfEntityDidNotExistsInDB;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.rm87097.gs.assembler.DroneAssemblerMapper;
import br.com.fiap.rm87097.gs.model.Drone;
import br.com.fiap.rm87097.gs.resources.DroneResource;

@Service
public class DroneService {

	@Autowired
	private DroneAssemblerMapper assembler;
	
	public void save(@Valid DroneResource resource) {
		validateIfEntityAlreadyExistsInDB(resource);
		add(assembler.toModel(resource));
	}

	public Drone findByIdentificacao(String identificacao) {
		validateIfEntityDidNotExistsInDB(identificacao);
		Drone entityFounded = findSourceByIdentificacao(identificacao);
		return entityFounded;
	}



	
	
}
