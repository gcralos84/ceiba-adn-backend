package com.ceiba.citamedica.carlos.gonzalez.consultamedica.controlador;

import com.ceiba.citamedica.carlos.gonzalez.ApplicationMock;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.ComandoConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicio.testdatabuilder.ComandoConsultaMedicaTestDataBuilder;
import com.ceiba.citamedica.carlos.gonzalez.especialista.ComandoEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.controlador.ComadoControladorEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.testdatabuilder.ComandoEspecialistaTestDataBuilder;
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
@WebMvcTest(ComandoControladorConsultaMedica.class)
public class ComadoControladorCitaMedicaTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    private ComandoConsultaMedica comandoConsultaMedica;

    @Before
    public void setUp(){
        comandoConsultaMedica = new ComandoConsultaMedicaTestDataBuilder().build();
    }
    @Test
    public void  crearTest() throws Exception {
        //act - assert
        mocMvc.perform(post("/consultamedica")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoConsultaMedica)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor':2}"));
    }
    @Test
    public void  actulizarTest() throws Exception {
        //act - assert
        String  identificacion ="1";
        //act - assert
        mocMvc.perform(put("/consultamedica/{id}",identificacion)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoConsultaMedica)))
                .andExpect(status().isOk());
    }
    @Test
    public void  eliminarTest() throws Exception {
        //act - assert
        String  identificacion ="1";
        //act - assert
        mocMvc.perform(delete("/consultamedica/{id}",identificacion)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoConsultaMedica)))
                .andExpect(status().isOk());
    }

}
