package com.projeto.Transportadora.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.Transportadora.entities.Empresa;
import com.projeto.Transportadora.repositories.EmpresaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public void run(String... args) throws Exception {
		Empresa empresa1 = new Empresa(null, "Filial1", 1, 10, 10.0);
		Empresa empresa2 = new Empresa(null, "Filial2", 2, 20, 20.0);

		empresaRepository.saveAll(Arrays.asList(empresa1, empresa2));
	}
}
