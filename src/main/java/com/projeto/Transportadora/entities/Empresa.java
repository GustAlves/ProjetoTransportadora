package com.projeto.Transportadora.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFilial;
	private Boolean aereo;
	private Boolean terrestre;
	private Double valorTotalAereo;
	private Double valorTotalTerrestre;
	private Integer tempoTotalAereo;
	private Integer tempoTotalTerrestre;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos = new ArrayList<>();

	public Empresa() {
	}

	public Empresa(Long id, String nomeFilial, Boolean aereo, Boolean terrestre, Double valorTotalAereo,
			Double valorTotalTerrestre, Integer tempoTotalAereo, Integer tempoTotalTerrestre) {
		super();
		this.id = id;
		this.nomeFilial = nomeFilial;
		this.aereo = aereo;
		this.terrestre = terrestre;
		this.valorTotalAereo = valorTotalAereo;
		this.valorTotalTerrestre = valorTotalTerrestre;
		this.tempoTotalAereo = tempoTotalAereo;
		this.tempoTotalTerrestre = tempoTotalTerrestre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public Boolean getAereo() {
		return aereo;
	}

	public void setAereo(Boolean aereo) {
		this.aereo = aereo;
	}

	public Boolean getTerrestre() {
		return terrestre;
	}

	public void setTerrestre(Boolean terrestre) {
		this.terrestre = terrestre;
	}

	public Double getValorTotalAereo() {
		return valorTotalAereo;
	}

	public void setValorTotalAereo(Double valorTotalAereo) {
		this.valorTotalAereo = valorTotalAereo;
	}

	public Double getValorTotalTerrestre() {
		return valorTotalTerrestre;
	}

	public void setValorTotalTerrestre(Double valorTotalTerrestre) {
		this.valorTotalTerrestre = valorTotalTerrestre;
	}

	public Integer getTempoTotalAereo() {
		return tempoTotalAereo;
	}

	public void setTempoTotalAereo(Integer tempoTotalAereo) {
		this.tempoTotalAereo = tempoTotalAereo;
	}

	public Integer getTempoTotalTerrestre() {
		return tempoTotalTerrestre;
	}

	public void setTempoTotalTerrestre(Integer tempoTotalTerrestre) {
		this.tempoTotalTerrestre = tempoTotalTerrestre;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aereo == null) ? 0 : aereo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeFilial == null) ? 0 : nomeFilial.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
		result = prime * result + ((tempoTotalAereo == null) ? 0 : tempoTotalAereo.hashCode());
		result = prime * result + ((tempoTotalTerrestre == null) ? 0 : tempoTotalTerrestre.hashCode());
		result = prime * result + ((terrestre == null) ? 0 : terrestre.hashCode());
		result = prime * result + ((valorTotalAereo == null) ? 0 : valorTotalAereo.hashCode());
		result = prime * result + ((valorTotalTerrestre == null) ? 0 : valorTotalTerrestre.hashCode());
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
		Empresa other = (Empresa) obj;
		if (aereo == null) {
			if (other.aereo != null)
				return false;
		} else if (!aereo.equals(other.aereo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeFilial == null) {
			if (other.nomeFilial != null)
				return false;
		} else if (!nomeFilial.equals(other.nomeFilial))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		if (tempoTotalAereo == null) {
			if (other.tempoTotalAereo != null)
				return false;
		} else if (!tempoTotalAereo.equals(other.tempoTotalAereo))
			return false;
		if (tempoTotalTerrestre == null) {
			if (other.tempoTotalTerrestre != null)
				return false;
		} else if (!tempoTotalTerrestre.equals(other.tempoTotalTerrestre))
			return false;
		if (terrestre == null) {
			if (other.terrestre != null)
				return false;
		} else if (!terrestre.equals(other.terrestre))
			return false;
		if (valorTotalAereo == null) {
			if (other.valorTotalAereo != null)
				return false;
		} else if (!valorTotalAereo.equals(other.valorTotalAereo))
			return false;
		if (valorTotalTerrestre == null) {
			if (other.valorTotalTerrestre != null)
				return false;
		} else if (!valorTotalTerrestre.equals(other.valorTotalTerrestre))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nomeFilial=" + nomeFilial + ", aereo=" + aereo + ", terrestre=" + terrestre
				+ ", valorTotalAereo=" + valorTotalAereo + ", valorTotalTerrestre=" + valorTotalTerrestre
				+ ", tempoTotalAereo=" + tempoTotalAereo + ", tempoTotalTerrestre=" + tempoTotalTerrestre + "]";
	}
}
