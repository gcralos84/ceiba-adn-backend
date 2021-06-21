package com.ceiba.citamedica.carlos.gonzalez.paciente.controlador;

import com.ceiba.citamedica.carlos.gonzalez.ApplicationMock;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.ComandoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.servico.testdatabuilder.ComandoPacienteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPaciente.class)
public class ComandoControladorPacienteTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;
    private ComandoPaciente paciente;
    
    @Before
    public void setUp(){
        paciente =   new ComandoPacienteTestDataBuilder().build();
     }
    
    @Test
    public void  crearTest() throws Exception {
        //act - assert
        mocMvc.perform(post("/paciente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paciente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor':2}"));
        
    }
    @Test
    public void  actulizarTest() throws Exception {
        //act - assert
        String  identificacion ="945525541";
        //act - assert
        mocMvc.perform(put("/paciente/{id}",identificacion)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paciente)))
                .andExpect(status().isOk());
    }
    @Test
    public void  eliminarTest() throws Exception {
        //act - assert
        String  identificacion ="945525541";
        //act - assert
        mocMvc.perform(delete("/paciente/{id}",identificacion)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paciente)))
                .andExpect(status().isOk());
    }
    
    
}
