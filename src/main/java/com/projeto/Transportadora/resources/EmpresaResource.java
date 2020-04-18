package com.projeto.Transportadora.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.Transportadora.entities.Empresa;
import com.projeto.Transportadora.services.EmpresaService;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaResource {

	@Autowired
	private EmpresaService service;

	@GetMapping
	public ResponseEntity<List<Empresa>> findAll() {
		List<Empresa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Empresa> findById(@PathVariable Long id) {
		Empresa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
