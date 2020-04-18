package com.projeto.Transportadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.Transportadora.entities.Empresa;
import com.projeto.Transportadora.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public List<Empresa> findAll() {
		return repository.findAll();
	}

	public Empresa findById(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		return obj.get();
	}
}
