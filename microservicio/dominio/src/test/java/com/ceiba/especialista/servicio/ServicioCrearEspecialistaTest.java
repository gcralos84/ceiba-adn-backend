package com.ceiba.especialista.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.especialista.servicio.testdatabuilder.EspecialistaTestDataBilder;
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
