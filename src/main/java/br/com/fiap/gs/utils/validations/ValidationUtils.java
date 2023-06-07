package br.com.fiap.gs.utils.validations;

import java.util.NoSuchElementException;
import java.util.Objects;

import br.com.fiap.gs.exceptions.EntityAlreadyExists;
import br.com.fiap.gs.exceptions.EntityNotFounded;
import br.com.fiap.gs.mockup.DadosCampoMockup;
import br.com.fiap.gs.mockup.DroneMockup;

public class ValidationUtils {

	public static void validateIfEntityAlreadyExistsInDB(String identificacao) {
		if (Objects.nonNull(DroneMockup.findSourceByIdentificacao(identificacao))) {
			throw new EntityAlreadyExists("Este drone já existe na base de dados, por favor, tente outra identificação.");
		}
	}

	public static void validateIfEntityDidNotExistsInDB(String identificacao) {
		try {
			DroneMockup.findSourceByIdentificacao(identificacao);
		} catch (NoSuchElementException e) {
			throw new EntityNotFounded("Drone não encontrado na base de dados, por favor, tente novamente.");
		}
	}
	
	public static void validateIfDadosCampoAlreadyExistsInDB(String identificacao) {
		if (Objects.nonNull(DadosCampoMockup.findSourceByIdentificacao(identificacao))) {
			throw new EntityAlreadyExists("Este drone já existe na base de dados, por favor, tente outra identificação.");
		}
	}

	public static void validateIfDadosCampoDidNotExistsInDB(String identificacao) {
		try {
			DadosCampoMockup.findSourceByIdentificacao(identificacao);
		} catch (NoSuchElementException e) {
			throw new EntityNotFounded("Drone não encontrado na base de dados, por favor, tente novamente.");
		}
	}
	
	
	
}
