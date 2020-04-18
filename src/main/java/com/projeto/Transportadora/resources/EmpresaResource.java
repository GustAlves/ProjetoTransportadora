package com.projeto.Transportadora.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.Transportadora.entities.Empresa;

@RestController
@RequestMapping(value = "/empresa")
public class EmpresaResource {

	@GetMapping
	public ResponseEntity<Empresa> findAll() {
		Empresa empresa = new Empresa(1L, "Filial", 1, 1, 2.0);
		return ResponseEntity.ok().body(empresa);
	}

}
