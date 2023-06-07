package br.com.fiap.gs.utils.validations;

import static java.util.Objects.nonNull;

import java.util.NoSuchElementException;

import br.com.fiap.gs.exceptions.EntityAlreadyExists;
import br.com.fiap.gs.exceptions.EntityNotFounded;
import br.com.fiap.gs.mockup.DadosCampoMockup;
import br.com.fiap.gs.mockup.DroneMockup;
import br.com.fiap.gs.model.DadosCampo;
import br.com.fiap.gs.model.Drone;

public class ValidationUtils {

	public static void validateIfEntityAlreadyExistsInDB(String identificacao) {
		Drone drone;
		try {
			drone = DroneMockup.findSourceByIdentificacao(identificacao);
		} catch (NoSuchElementException e) {
			return;
		}
		if (nonNull(drone)) {
			throw new EntityAlreadyExists("Este drone já existe na base de dados, por favor, tente novamente.");
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
		DadosCampo dadosCampo;
		try {
			dadosCampo = DadosCampoMockup.findSourceByIdentificacao(identificacao);
		} catch (NoSuchElementException e) {
			return;
		}
		if (nonNull(dadosCampo)) {
			throw new EntityAlreadyExists("Estes dados de campo já existe na base de dados, por favor, tente novamente.");
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
