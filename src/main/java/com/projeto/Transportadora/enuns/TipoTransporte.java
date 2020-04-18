package com.projeto.Transportadora.enuns;

public enum TipoTransporte {
	
	Aereo("aereo"),
	Terrestre("terrestre");

	private String tipoTransporte;
	
	private TipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}
}
