package com.projeto.Transportadora.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto.Transportadora.entities.Empresa;
import com.projeto.Transportadora.entities.Pedido;
import com.projeto.Transportadora.repositories.PedidoRepository;
import com.projeto.Transportadora.services.exceptions.DatabaseException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public List<Pedido> findAll() {
		return repository.findAll();
	}

	public Pedido findById(Long id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.get();
	}

	public ResponseEntity<?> melhorTransportadora(@RequestBody Pedido pedido) {

		try {
			// Valida campos obrigatórios
			if (pedido.getOrigem() == null || pedido.getDestino() == null || pedido.getDistancia() == null
					|| pedido.getPrioridade() == null) {
				throw new Exception("Campos obrigatórios não informados");
			}

			List<Empresa> empresasFiliais = new ArrayList<Empresa>();
			List<Empresa> empresas = new EmpresaService().findAll();

			for (Empresa empresaCorrente : empresas) {

				// Calculo de preço: Km x Valor / 10
				Empresa empresa = new Empresa();
				BigDecimal valorTotalAereo = new BigDecimal(0);
				BigDecimal valorTotalTerrestre = new BigDecimal(0);
				if (empresaCorrente.getValorTotalAereo().compareTo(BigDecimal.ZERO) > 0) {
					valorTotalAereo = pedido.getDistancia().multiply(empresaCorrente.getValorTotalAereo());
					valorTotalAereo = valorTotalAereo.divide(new BigDecimal(10));
				}
				if (empresaCorrente.getValorTotalTerrestre().compareTo(BigDecimal.ZERO) > 0) {
					valorTotalTerrestre = pedido.getDistancia().multiply(empresaCorrente.getValorTotalTerrestre());
					valorTotalTerrestre = valorTotalTerrestre.divide(new BigDecimal(10));
				}

				empresa.setId(empresaCorrente.getId());
				empresa.setNomeFilial(empresaCorrente.getNomeFilial());
				empresa.setValorTotalAereo(valorTotalAereo);
				empresa.setValorTotalTerrestre(valorTotalTerrestre);

				// Converte tempo em minutos
				empresa.setTempoTotalAereo(
						(empresaCorrente.getTempoTotalAereo() * Integer.parseInt(pedido.getDistancia().toString()))
								/ 60);
				empresa.setTempoTotalTerrestre(
						(empresaCorrente.getTempoTotalTerrestre() * Integer.parseInt(pedido.getDistancia().toString()))
								/ 60);

				empresasFiliais.add(empresa);
			}
			return ResponseEntity.ok().body(empresasFiliais.get(0));
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}