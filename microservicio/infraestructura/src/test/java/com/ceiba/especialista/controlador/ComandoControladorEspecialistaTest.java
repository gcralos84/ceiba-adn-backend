package com.ceiba.especialista.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.especialista.ComandoEspecialista;
import com.ceiba.especialista.servicio.testdatabuilder.ComandoEspecialistaTestDataBuilder;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComadoControladorEspecialista.class)
public class ComandoControladorEspecialistaTest {
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private MockMvc mocMvc;
    private ComandoEspecialista especialista;
    @Before
    public void setUp(){
        especialista =   new ComandoEspecialistaTestDataBuilder().build();
    }
    
    @Test
    public void  crearTest() throws Exception {
        //act - assert
        mocMvc.perform(post("/especialista")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(especialista)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor':2}"));
    }
    @Test
    public void  actulizarTest() throws Exception {
        //act - assert
        String  identificacion ="162439866";
        //act - assert
        mocMvc.perform(put("/especialista/{id}",identificacion)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(especialista)))
                .andExpect(status().isOk());
    }
    @Test
    public void  eliminarTest() throws Exception {
        //act - assert
        String  identificacion ="162439866";
        //act - assert
        mocMvc.perform(delete("/especialista/{id}",identificacion)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(especialista)))
                .andExpect(status().isOk());
    }
    
}
