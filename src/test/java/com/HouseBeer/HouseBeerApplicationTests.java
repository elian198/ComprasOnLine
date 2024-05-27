package com.HouseBeer;

import com.HouseBeer.controller.EmpresaController;
import com.HouseBeer.datos.Datos;
import com.HouseBeer.service.EmpresaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@WebMvcTest(EmpresaController.class)
class HouseBeerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private EmpresaService empresaService;
	@Test
	void testFindAll() throws Exception {
		mockMvc.perform(get("/api/empresa").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.nombre").value("Matilde"));
	}

	@Test
	void testFindByName() throws Exception {
		when(this.empresaService.findByName("Matilde")).thenReturn(Datos.EMPRESA);
		mockMvc.perform(get("/api/empresa/findByName")
						.param("name", "Matilde")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));

	}


}
