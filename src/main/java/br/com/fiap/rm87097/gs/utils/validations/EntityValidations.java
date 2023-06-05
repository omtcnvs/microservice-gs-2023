package br.com.fiap.rm87097.gs.utils.validations;

import static br.com.fiap.rm87097.gs.mockup.DroneMockup.findSourceByIdentificacao;
import static java.util.Objects.nonNull;

import java.util.NoSuchElementException;

import br.com.fiap.rm87097.gs.exceptions.EntityAlreadyExists;
import br.com.fiap.rm87097.gs.exceptions.EntityNotFounded;

public class EntityValidations {

	public static void validateIfEntityAlreadyExistsInDB(String  identificacao) {
		if (nonNull(findSourceByIdentificacao(identificacao))) {
			throw new EntityAlreadyExists("Já há um drone salvo na base de dados com esta identificação, por favor, escolha outro.");
		}
	}
	
	public static void validateIfEntityDidNotExistsInDB(String identificacao) {
		try {
			findSourceByIdentificacao(identificacao);
		} catch(NoSuchElementException e) {
			throw new EntityNotFounded("Drone não encontrado, por favor, tente outra identificação.");
		}
	}
	
}
