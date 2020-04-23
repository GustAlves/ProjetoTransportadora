package com.projeto.TransportadoraCardboardBoxCompany;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@WebAppConfiguration
class TransportadoraCardboardBoxCompanyApplicationTests {

	@Autowired
	public WebApplicationContext context;

	private MockMvc mock;

	@BeforeTestClass
	public void Setup() {
		this.mock = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void TesteSaoPauloManaus() throws Exception {
	}

	@Test
	public void TesteFlorianopolisCampinas() throws Exception {
	}

	@Test
	public void TesteSalvadorBelem() throws Exception {
	}

	@Test
	public void TesteSaoPauloAssuncao() throws Exception {
	}

	@Test
	public void TesteSalvadorBrasilia() throws Exception {
	}
}
