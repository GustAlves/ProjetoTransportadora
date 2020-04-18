package com.projeto.Transportadora.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeFilial;
	private Integer tipoTransporte;
	private Integer tempo;
	private Double valor;
	
	public Empresa() {
	}

	public Empresa(Long id, String nomeFilial, Integer tipoTransporte, Integer tempo, Double valor) {
		super();
		this.id = id;
		this.nomeFilial = nomeFilial;
		this.tipoTransporte = tipoTransporte;
		this.tempo = tempo;
		this.valor = valor;
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

	public Integer getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(Integer tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeFilial == null) ? 0 : nomeFilial.hashCode());
		result = prime * result + ((tempo == null) ? 0 : tempo.hashCode());
		result = prime * result + ((tipoTransporte == null) ? 0 : tipoTransporte.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		if (tempo == null) {
			if (other.tempo != null)
				return false;
		} else if (!tempo.equals(other.tempo))
			return false;
		if (tipoTransporte == null) {
			if (other.tipoTransporte != null)
				return false;
		} else if (!tipoTransporte.equals(other.tipoTransporte))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
}
