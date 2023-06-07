package br.com.fiap.gs.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.gs.mockup.DadosCampoMockup;
import br.com.fiap.gs.mockup.DroneMockup;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"br.com.fiap.gs.controller", "br.com.fiap.gs.service", "br.com.fiap.gs.assembler"})
public class MicroserviceGs2023Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGs2023Application.class, args);
		DadosCampoMockup.load();
		DroneMockup.load();
	}

}
