package br.com.fiap.gs.controller;

import static br.com.fiap.gs.utils.ConstantsUtils.DELETE_IDENTIFICACAO_URI;
import static br.com.fiap.gs.utils.ConstantsUtils.EDIT_IDENTIFICACAO_URI;
import static br.com.fiap.gs.utils.ConstantsUtils.IDENTIFICACAO_URI;
import static br.com.fiap.gs.utils.ConstantsUtils.SAVE_URI;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.gs.dtos.DadosCampoDTO;
import br.com.fiap.gs.model.DadosCampo;
import br.com.fiap.gs.service.DadosCampoService;
import br.com.fiap.gs.utils.ConstantsUtils;

@RestController
@RequestMapping(value = ConstantsUtils.V1_DADOS_CAMPOS)
public class DadosCampoController {

	@Autowired
	private DadosCampoService service;

	@GetMapping()
	public ResponseEntity<List<DadosCampo>> getAll() {
		return ok(service.getAll());
	}

	@PostMapping(value = SAVE_URI)
	public ResponseEntity<DadosCampo> save(@RequestBody @Valid DadosCampoDTO resource) {
		service.save(resource);
		return status(HttpStatus.CREATED).build();
	}

	@GetMapping(value = IDENTIFICACAO_URI)
	public ResponseEntity<DadosCampo> findByIdentificacao(@PathVariable String identificacao) {
		DadosCampo entityFinded = service.findByIdentificacao(identificacao);
		return ok(entityFinded);
	}

	@PutMapping(value = EDIT_IDENTIFICACAO_URI)
	public ResponseEntity<DadosCampo> putDrone(@PathVariable String identificacao,
			@RequestBody @Valid DadosCampoDTO resource) {
		DadosCampo modelUpdated = service.put(identificacao, resource);
		return ok(modelUpdated);
	}

	@DeleteMapping(value = DELETE_IDENTIFICACAO_URI)
	public ResponseEntity<DadosCampo> deleteDrone(@PathVariable String identificacao) {
		service.deleteByIdentificacao(identificacao);
		return status(HttpStatus.NO_CONTENT).build();
	}

}
