package br.com.fiap.gs.mockup;

import static br.com.fiap.gs.builders.FactoryObjects.buildDadosCampoDrone01;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.gs.model.DadosCampo;

public class DadosCampoMockup {

private static final List<DadosCampo> db = new ArrayList<>();
	
	public static void load() {
		db.add(buildDadosCampoDrone01());
	}
	
	public static void add(DadosCampo model) {
		db.add(model);
	}
	
	public static DadosCampo findSourceByIdentificacao(String identificacao) {
		return db.stream().filter(data -> data.getIdentificacaoDrone().equals(identificacao)).findFirst().get();
	}
	
	public static DadosCampo returnTheLastDrone() {
		return db.get(db.size());
	}
	
	public static List<DadosCampo> getAll() {
		return db;
	}
	
	public static void delete(DadosCampo modelToDelete) {
		db.remove(modelToDelete);
	}
	
}
