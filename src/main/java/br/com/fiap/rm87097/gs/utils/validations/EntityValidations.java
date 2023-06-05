package br.com.fiap.rm87097.gs.utils.validations;

import static br.com.fiap.rm87097.gs.mockup.DroneMockup.findSourceByIdentificacao;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import br.com.fiap.rm87097.gs.exceptions.EntityAlreadyExists;
import br.com.fiap.rm87097.gs.exceptions.EntityNotFounded;
import br.com.fiap.rm87097.gs.resources.DroneResource;

public class EntityValidations {

	public static void validateIfEntityAlreadyExistsInDB(DroneResource resource) {
		if (nonNull(findSourceByIdentificacao(resource.getIdentificacao()))) {
			throw new EntityAlreadyExists("Já há um drone salvo na base de dados com esta identificação, por favor, escolha outro.");
		}
	}
	
	public static void validateIfEntityDidNotExistsInDB(String identificacao) {
		if (isNull(findSourceByIdentificacao(identificacao))) {
			throw new EntityNotFounded("Drone não encontrado, por favor, tente outra identificação.");
		}
	}
	
}
