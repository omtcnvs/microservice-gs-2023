package br.com.fiap.rm87097.gs.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.rm87097.gs.mockup.DroneMockup;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"br.com.fiap.rm87097.gs.controller", "br.com.fiap.rm87097.gs.service", "br.com.fiap.rm87097.gs.assembler"})
public class MicroserviceGs2023Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGs2023Application.class, args);
		DroneMockup.load();
	}

}
