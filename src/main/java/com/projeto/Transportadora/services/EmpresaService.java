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

	public Empresa insert(Empresa obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Empresa update(Long id, Empresa obj) {
		Empresa entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Empresa entity, Empresa obj) {
		entity.setNomeFilial(obj.getNomeFilial());
		entity.setAereo(obj.getAereo());
		entity.setTerrestre(obj.getTerrestre());
		entity.setValorTotalAereo(obj.getValorTotalAereo());
		entity.setValorTotalTerrestre(obj.getValorTotalTerrestre());
		entity.setTempoTotalAereo(obj.getTempoTotalAereo());
		entity.setTempoTotalTerrestre(obj.getTempoTotalTerrestre());
	}
}
