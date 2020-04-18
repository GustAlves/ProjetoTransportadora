package com.projeto.Transportadora.enuns;

public enum Prioridade {

	Preco("preco"), 
	Tempo("tempo");

	private String prioridade;

	Prioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getPrioridade() {
		return prioridade;
	}
}
