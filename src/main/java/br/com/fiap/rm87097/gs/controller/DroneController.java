package br.com.fiap.rm87097.gs.controller;

import static br.com.fiap.rm87097.gs.utils.ConstantsUtils.SAVE_URI;
import static br.com.fiap.rm87097.gs.utils.ConstantsUtils.V1_DRONES;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.rm87097.gs.mockup.DroneMockup;
import br.com.fiap.rm87097.gs.model.Drone;
import br.com.fiap.rm87097.gs.resources.DroneResource;
import br.com.fiap.rm87097.gs.service.DroneService;
import br.com.fiap.rm87097.gs.utils.ConstantsUtils;

@RestController()
@RequestMapping(V1_DRONES)
public class DroneController {

	@Autowired
	private DroneService service;
	
	@GetMapping()
	public List<Drone> getAll() {
		return DroneMockup.getAll();
	}
	
	@PostMapping(value = SAVE_URI)
	public ResponseEntity<Null> save(@RequestBody @Valid DroneResource resource) {
		service.save(resource);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ConstantsUtils.NULL_STATE);
	}
	
	@GetMapping(value = "/{identificacao}")
	public ResponseEntity<Drone> findByIdentificacao(@PathVariable String identificacao) {
		Drone entityFinded = service.findByIdentificacao(identificacao);
		return ResponseEntity.ok(entityFinded);
	}
	
	
	
	
}
