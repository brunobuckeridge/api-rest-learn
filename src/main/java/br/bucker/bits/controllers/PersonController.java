package br.bucker.bits.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.bucker.bits.data.vo.v1.PersonVO;
import br.bucker.bits.services.PersonServices;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonServices service;

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<PersonVO> findAll() throws Exception {
		return service.findAll();
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public PersonVO findById(@PathVariable Long id) throws Exception {
		return service.findById(id);
	}

	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			    consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public PersonVO create(@RequestBody PersonVO person) throws Exception {
		return service.create(person);
	}

	@PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
			    consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public PersonVO update(@RequestBody PersonVO person) throws Exception {
		return service.update(person);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
