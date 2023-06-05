package br.com.fiap.gs.mockup;

import static br.com.fiap.gs.builders.FactoryObjects.buildDrone01;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.gs.model.Drone;

public class DroneMockup {

	private static final List<Drone> db = new ArrayList<>();
	
	public static void load() {
		db.add(buildDrone01());
	}
	
	public static void add(Drone model) {
		db.add(model);
	}
	
	public static Drone findSourceByIdentificacao(String identificacao) {
		return db.stream().filter(data -> data.getIdentificacao().equals(identificacao)).findFirst().get();
	}
	
	public static Drone returnTheLastDrone() {
		return db.get(db.size());
	}
	
	public static List<Drone> getAll() {
		return db;
	}
	
	public static void delete(Drone modelToDelete) {
		db.remove(modelToDelete);
	}
	
}
