package br.com.fiap.gs.service;

import static br.com.fiap.gs.mockup.DadosCampoMockup.add;
import static br.com.fiap.gs.mockup.DadosCampoMockup.findSourceByIdentificacao;
import static br.com.fiap.gs.utils.validations.ValidationUtils.validateIfEntityAlreadyExistsInDB;
import static br.com.fiap.gs.utils.validations.ValidationUtils.validateIfEntityDidNotExistsInDB;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.gs.assembler.DadosCampoAssemblerMapper;
import br.com.fiap.gs.dtos.DadosCampoDTO;
import br.com.fiap.gs.mockup.DroneMockup;
import br.com.fiap.gs.model.DadosCampo;
import br.com.fiap.gs.model.Drone;

@Service
public class DadosCampoService {

	@Autowired
	private DadosCampoAssemblerMapper assembler;
	
	// ************************************
	//			MÉTODOS PÚBLICOS
	// ************************************
	
	public void save(@Valid DadosCampoDTO resource) {
		validateIfEntityAlreadyExistsInDB(resource.getIdentificacaoDrone());
		add(assembler.toModel(resource));
	}

	public DadosCampo findByIdentificacao(String identificacaoDrone) {
		validateIfEntityDidNotExistsInDB(identificacaoDrone);
		return findSourceByIdentificacao(identificacaoDrone);
	}

	public DadosCampo putDrone(String identificacaoDrone, @Valid DadosCampoDTO resource) {
		validateIfEntityDidNotExistsInDB(identificacaoDrone);
		validateIfEntityAlreadyExistsInDB(resource.getIdentificacaoDrone());
		return updateEntityFields(identificacaoDrone, resource);
	}
	
	// ************************************
	//			MÉTODOS PRIVADOS
	// ************************************

	private DadosCampo updateEntityFields(String identificacao, DadosCampoDTO resource) {
		DadosCampo modelToUpdate = findSourceByIdentificacao(identificacao);
		return modelToUpdate;
	}

	public List<DadosCampo> getAll() {
		return getAll();
	}

	public void deleteByIdentificacao(String identificacao) {
		Drone modelToDelete = DroneMockup.findSourceByIdentificacao(identificacao);
		DroneMockup.delete(modelToDelete);
	}
	
}
