package com.ceiba.citamedica.carlos.gonzalez.especialista.controlador;

import com.ceiba.citamedica.carlos.gonzalez.ApplicationMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorEspecialista.class)
public class ConsultarControladorEspecialsitaTest {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    public void  listarTest() throws Exception {
        //arrange
        //act - assert
         mockMvc. perform(get("/especialistas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is("Luis Arturo")));
    }
    @Test
    public void  listarConsultaAgenda() throws Exception {
        //arrange
        //act - assert
        mockMvc. perform(get("/especialistas")
                .contentType(MediaType.APPLICATION_JSON)
                .param("fechaCita","2021-06-24")
                .param("horaCita", "19:59:00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].nombre", is("Luis Arturo")));
    }
}
