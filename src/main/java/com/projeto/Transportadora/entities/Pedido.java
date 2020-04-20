package com.projeto.Transportadora.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.Transportadora.enuns.Prioridade;
import com.projeto.Transportadora.enuns.TipoTransporte;

@Entity
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataPedido;
	private String origem;
	private String destino;
	private BigDecimal distancia;
	private Prioridade prioridade;
	private TipoTransporte tipoTransporte;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Empresa cliente;

	public Pedido() {
	}

	public Pedido(Long id, Instant dataPedido, String origem, String destino, BigDecimal distancia,
			Prioridade prioridade, TipoTransporte tipoTransporte, Empresa cliente) {
		super();
		this.id = id;
		this.dataPedido = dataPedido;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		setPrioridade(prioridade);
		setTipoTransporte(tipoTransporte);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public BigDecimal getDistancia() {
		return distancia;
	}

	public void setDistancia(BigDecimal distancia) {
		this.distancia = distancia;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public Empresa getCliente() {
		return cliente;
	}

	public void setCliente(Empresa cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
