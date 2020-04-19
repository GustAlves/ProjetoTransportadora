package com.projeto.Transportadora.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projeto.Transportadora.entities.Empresa;
import com.projeto.Transportadora.repositories.EmpresaRepository;
import com.projeto.Transportadora.services.exceptions.DatabaseException;
import com.projeto.Transportadora.services.exceptions.ResourceNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	public List<Empresa> findAll() {
		return repository.findAll();
	}

	public Empresa findById(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Empresa insert(Empresa obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Empresa update(Long id, Empresa obj) {
		try {
			Empresa entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
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
