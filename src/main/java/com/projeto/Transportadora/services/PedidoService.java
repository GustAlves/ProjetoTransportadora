package com.projeto.Transportadora.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.projeto.Transportadora.entities.Empresa;
import com.projeto.Transportadora.entities.Pedido;
import com.projeto.Transportadora.enuns.Prioridade;
import com.projeto.Transportadora.enuns.TipoTransporte;
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
			validaCamposObrigatorios(pedido);

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

			// Ordenação das empresas, verificando preço, prioridade e tipo de transporte
			if (Prioridade.Preco.equals(pedido.getPrioridade())) {
				if (TipoTransporte.Aereo.equals(pedido.getTipoTransporte())) {
					Collections.sort(empresasFiliais, new Comparator<Empresa>() {

						@Override
						public int compare(Empresa filial1, Empresa filial2) {
							if (filial1.getValorTotalAereo().compareTo(BigDecimal.ZERO) > 0) {
								return filial1.getValorTotalAereo().compareTo(filial2.getValorTotalAereo());
							} else {
								return filial1.getValorTotalAereo().intValue();
							}
						}
					});

				} else if (TipoTransporte.Terrestre.equals(pedido.getTipoTransporte())) {
					Collections.sort(empresasFiliais, new Comparator<Empresa>() {

						@Override
						public int compare(Empresa filial1, Empresa filial2) {
							if (filial1.getValorTotalTerrestre().compareTo(BigDecimal.ZERO) > 0) {
								return filial1.getValorTotalTerrestre().compareTo(filial2.getValorTotalTerrestre());
							} else {
								return filial1.getValorTotalTerrestre().intValue();
							}
						}

					});
				}
			} else if (Prioridade.Tempo.equals(pedido.getPrioridade())) {
				if (TipoTransporte.Aereo.equals(pedido.getTipoTransporte())) {
					Collections.sort(empresasFiliais, new Comparator<Empresa>() {

						@Override
						public int compare(Empresa filial1, Empresa filial2) {
							return filial1.getTempoTotalAereo().compareTo(filial2.getTempoTotalAereo());
						}

					});
				} else if (TipoTransporte.Terrestre.equals(pedido.getTipoTransporte())) {
					Collections.sort(empresasFiliais, new Comparator<Empresa>() {

						@Override
						public int compare(Empresa filial1, Empresa filial2) {
							return filial1.getTempoTotalTerrestre().compareTo(filial2.getTempoTotalTerrestre());
						}

					});
				}
			}
			
			return ResponseEntity.ok().body(empresasFiliais.get(0));
		} catch (Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	private void validaCamposObrigatorios(Pedido pedido) throws Exception {
		if (pedido.getOrigem() == null) {
			throw new Exception("Campo Origem é obrigatório");
		}
		if (pedido.getDestino() == null) {
			throw new Exception("Campo Destino é obrigatório");
		}
		if (pedido.getDistancia() == null) {
			throw new Exception("Campo Distancia é obrigatório");
		}
		if (pedido.getPrioridade() == null) {
			throw new Exception("Campo Prioridade é obrigatório");
		}
	}
}