package com.projeto.Transportadora.enuns;

public enum TipoTransporte {

	Aereo(1), Terrestre(2);

	private int code;

	private TipoTransporte(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static TipoTransporte valueOf(int code) {
		for (TipoTransporte value : TipoTransporte.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Tipo de Transporte Invalido");
	}
}
