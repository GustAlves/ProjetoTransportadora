package com.projeto.Transportadora.enuns;

public enum Prioridade {

	Preco(1), Tempo(2);

	private int code;

	private Prioridade(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static Prioridade valueOf(int code) {
		for (Prioridade value : Prioridade.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Prioridade Invalida");
	}
}
