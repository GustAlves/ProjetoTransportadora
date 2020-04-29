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
		
		empresaRepository.deleteAll();
		pedidoRepository.deleteAll();
		
		Empresa empresa1 = new Empresa(null, "Transportadora 1", true, false, new BigDecimal(0), new BigDecimal(60), 0,
				50);
		Empresa empresa2 = new Empresa(null, "Transportadora 2", true, true, new BigDecimal(30), new BigDecimal(59),
				200, 75);
		Empresa empresa3 = new Empresa(null, "Transportadora 3", true, false, new BigDecimal(33), new BigDecimal(63),
				180, 55);
		Empresa empresa4 = new Empresa(null, "Transportadora 4", false, true, new BigDecimal(30), new BigDecimal(0),
				175, 0);
		Empresa empresa5 = new Empresa(null, "Transportadora 5", false, true, new BigDecimal(0), new BigDecimal(0), 0,
				0);
		
		Pedido p1 = new Pedido(null, Instant.parse("2020-04-18T19:15:07Z"), "Araras", "Limeira", new BigDecimal(30),
				Prioridade.Preco, TipoTransporte.Terrestre, empresa2);
		Pedido p2 = new Pedido(null, Instant.parse("2020-04-18T19:15:07Z"), "Araras", "Minas Gerais",
				new BigDecimal(800), Prioridade.Preco, TipoTransporte.Aereo, empresa1);

		empresaRepository.saveAll(Arrays.asList(empresa1, empresa2,empresa3, empresa4, empresa5));
		pedidoRepository.saveAll(Arrays.asList(p1, p2));
	}
}
