package br.com.fiap.gs.service;

import static br.com.fiap.gs.mockup.DadosCampoMockup.add;
import static br.com.fiap.gs.mockup.DadosCampoMockup.findSourceByIdentificacao;
import static br.com.fiap.gs.utils.validations.ValidationUtils.validateIfDadosCampoAlreadyExistsInDB;
import static br.com.fiap.gs.utils.validations.ValidationUtils.validateIfDadosCampoDidNotExistsInDB;
import static java.util.Objects.isNull;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.gs.assembler.DadosCampoAssemblerMapper;
import br.com.fiap.gs.dtos.DadosCampoDTO;
import br.com.fiap.gs.mockup.DadosCampoMockup;
import br.com.fiap.gs.model.DadosCampo;

@Service
public class DadosCampoService {

	@Autowired
	private DadosCampoAssemblerMapper assembler;
	
	// ************************************
	//			MÉTODOS PÚBLICOS
	// ************************************
	
	public void save(@Valid DadosCampoDTO resource) {
		validateIfDadosCampoAlreadyExistsInDB(resource.getIdentificacaoDrone());
		add(assembler.toModel(resource));
	}

	public DadosCampo findByIdentificacao(String identificacao) {
		validateIfDadosCampoDidNotExistsInDB(identificacao);
		return findSourceByIdentificacao(identificacao);
	}

	public DadosCampo put(String identificacao, @Valid DadosCampoDTO resource) {
		validateIfDadosCampoDidNotExistsInDB(identificacao);
		validateIfDadosCampoAlreadyExistsInDB(resource.getIdentificacaoDrone());
		return updateEntityFields(identificacao, resource);
	}
	
	// ************************************
	//			MÉTODOS PRIVADOS
	// ************************************

	private DadosCampo updateEntityFields(String identificacao, DadosCampoDTO resource) {
		DadosCampo modelToUpdate = findSourceByIdentificacao(identificacao);
		modelToUpdate.setDataEHora(isNull(resource.getDataEHora()) ? modelToUpdate.getDataEHora() : resource.getDataEHora());
		modelToUpdate.setDirecao(isNull(resource.getDirecao()) ? modelToUpdate.getDirecao() : resource.getDirecao());
		modelToUpdate.setIdentificacaoDrone(isNull(resource.getIdentificacaoDrone()) ? modelToUpdate.getIdentificacaoDrone() : resource.getIdentificacaoDrone());
		modelToUpdate.setLagitude(isNull(resource.getLagitude()) ? modelToUpdate.getLagitude() : resource.getLagitude());
		modelToUpdate.setLongitude(isNull(resource.getLongitude()) ? modelToUpdate.getLongitude() : resource.getLongitude());
		modelToUpdate.setVelocidade(isNull(resource.getVelocidade()) ? modelToUpdate.getVelocidade() : resource.getVelocidade());
		return modelToUpdate;	
	}

	public List<DadosCampo> getAll() {
		return DadosCampoMockup.getAll();
	}

	public void deleteByIdentificacao(String identificacao) {
		validateIfDadosCampoDidNotExistsInDB(identificacao);
		DadosCampo modelToDelete = DadosCampoMockup.findSourceByIdentificacao(identificacao);
		DadosCampoMockup.delete(modelToDelete);
	}
	
}
