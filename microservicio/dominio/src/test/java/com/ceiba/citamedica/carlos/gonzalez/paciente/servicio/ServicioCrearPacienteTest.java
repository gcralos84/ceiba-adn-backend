package com.ceiba.citamedica.carlos.gonzalez.paciente.servicio;

import com.ceiba.citamedica.carlos.gonzalez.BasePrueba;
import com.ceiba.citamedica.carlos.gonzalez.paciente.servicio.testdatabuilder.PacienteTestDatabuilder;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.entidad.Paciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.repositorio.RepositorioPaciente;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearPacienteTest {
    
    @Test
    public void  validarSiExistePacienteTest(){
         //arange
        Paciente paciente = new PacienteTestDatabuilder().build();
        RepositorioPaciente  repositorioPaciente = Mockito.mock(RepositorioPaciente.class);
        Mockito.when(repositorioPaciente.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPaciente servicioCrearPaciente = new ServicioCrearPaciente(repositorioPaciente);
        //act-assert
        BasePrueba.assertThrows(()-> servicioCrearPaciente.ejecutar(paciente), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }

}
