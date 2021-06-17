package com.ceiba.citamedica.carlos.gonzalez.especialista.servicio;

import com.ceiba.citamedica.carlos.gonzalez.BasePrueba;
import com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.testdatabuilder.EspecialistaTestDataBilder;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad.Especialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.repositorio.RepositorioEspecialista;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearEspecialistaTest {
    
    @Test
    public void validarSiExisteEspecialistaTest(){
          //arrange
         Especialista especialista = new EspecialistaTestDataBilder().build();
         RepositorioEspecialista  repositorioEspecialista  = Mockito.mock(RepositorioEspecialista.class);
         Mockito.when(repositorioEspecialista.existe(Mockito.anyString())).thenReturn(true);
         ServicioCrearEspecialista servicioCrearEspecialista = new ServicioCrearEspecialista(repositorioEspecialista);
         //act-assert
         BasePrueba.assertThrows(()-> servicioCrearEspecialista.ejecutar(especialista), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
        
    }
}
