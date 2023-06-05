package br.com.fiap.rm87097.gs.mockup;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.rm87097.gs.model.DadosVoo;
import br.com.fiap.rm87097.gs.model.Drone;
import br.com.fiap.rm87097.gs.model.HistoricoVoo;
import br.com.fiap.rm87097.gs.model.LicencaVoo;

public class DroneMockup {

	private static final List<Drone> db = new ArrayList<>();
	
	public static void load() {
		db.add(buildDrone01());
	}
	
	public static void add(Drone model) {
		db.add(model);
	}
	
	public static Drone findSourceByIdentificacao(String id) {
		return db.stream().filter(data -> data.getIdentificacao().equals(id)).findFirst().get();
	}
	
	public static Drone returnTheLastDrone() {
		return db.get(db.size());
	}
	
	public static List<Drone> getAll() {
		return db;
	}
	
    private static Drone buildDrone01() {
    	Drone model = Drone.builder()
                .identificacao("Drone01")
                .modelo("DJI Phantom 4 Pro")
                .numeroSerie(3472903467234L)
                .licencaVoo(buildLicencaVoo())
                .capacidadeBateria(100)
                .capacidadeCarga(280)
                .historicoVoo(new HistoricoVoo())
                .horasDeVoo(3600).build();
    	model.getHistoricoVoo().add(buildDadosVoo());
		return model;
    }

	private static DadosVoo buildDadosVoo() {
		return DadosVoo.builder()
				.altura(200)
				.coordenadasFimBVoo(23465782956L)
				.coordenadasInicioVoo(17283901203718L)
				.data(LocalDateTime.now())
				.duracaoVoo(200)
				.horario(LocalTime.now())
				.velocidadeMedia(180)
				.build();
	}

	private static LicencaVoo buildLicencaVoo() {
        return LicencaVoo.builder()
                .numeroLicenca(6237482637492L)
                .dataEmissao(LocalDateTime.now())
                .validade(true)
                .build();
    }
	
}
