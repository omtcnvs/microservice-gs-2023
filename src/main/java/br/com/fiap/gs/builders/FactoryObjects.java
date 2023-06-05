package br.com.fiap.gs.builders;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import br.com.fiap.gs.model.DadosCampo;
import br.com.fiap.gs.model.DadosHistoricoVoo;
import br.com.fiap.gs.model.Drone;
import br.com.fiap.gs.model.LicencaVoo;

public class FactoryObjects {

    public static Drone buildDrone01() {
    	Drone model = Drone.builder()
                .identificacao("Drone01")
                .modelo("DJI Phantom 4 Pro")
                .numeroSerie(3472903467234L)
                .licencaVoo(buildLicencaVoo())
                .capacidadeBateria(100)
                .capacidadeCarga(280)
                .historicoVoo(new ArrayList<DadosHistoricoVoo>())
                .horasDeVoo(3600).build();
    	model.getHistoricoVoo().add(buildDadosVoo());
		return model;
    }

    private static DadosHistoricoVoo buildDadosVoo() {
		return DadosHistoricoVoo.builder()
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
    
    public static DadosCampo buildDadosCampoDrone01() {
    	return DadosCampo.builder().dataEHora(LocalDateTime.now())
    			.identificacaoDrone("Drone01")
    			.direcao(0.5)
    			.lagitude(2637489623L)
    			.longitude(1723891723L)
    			.velocidade(200)
    			.build();
    }
	
}
