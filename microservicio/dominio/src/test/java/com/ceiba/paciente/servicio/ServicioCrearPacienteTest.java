package com.ceiba.paciente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.paciente.modelo.entidad.Paciente;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.paciente.servicio.testdatabuilder.PacienteTestDatabuilder;
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
