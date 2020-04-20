package com.projeto.Transportadora.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.Transportadora.entities.Empresa;
import com.projeto.Transportadora.entities.Pedido;
import com.projeto.Transportadora.enuns.Prioridade;
import com.projeto.Transportadora.enuns.TipoTransporte;
import com.projeto.Transportadora.repositories.EmpresaRepository;
import com.projeto.Transportadora.repositories.PedidoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		Empresa empresa1 = new Empresa(null, "Filial1", true, false, new BigDecimal(100.00), new BigDecimal(0.0), 50,0);
		Empresa empresa2 = new Empresa(null, "Filial2", false, true, new BigDecimal(0.00), new BigDecimal(50.0), 0, 30);

		Pedido p1 = new Pedido(null, Instant.parse("2020-04-18T19:15:07Z"), "Araras", "Limeira", new BigDecimal(30),
				Prioridade.Preco, TipoTransporte.Terrestre, empresa2);
		Pedido p2 = new Pedido(null, Instant.parse("2020-04-18T19:15:07Z"), "Araras", "Minas Gerais",
				new BigDecimal(800), Prioridade.Preco, TipoTransporte.Aereo, empresa1);

		empresaRepository.saveAll(Arrays.asList(empresa1, empresa2));
		pedidoRepository.saveAll(Arrays.asList(p1, p2));
	}
}
