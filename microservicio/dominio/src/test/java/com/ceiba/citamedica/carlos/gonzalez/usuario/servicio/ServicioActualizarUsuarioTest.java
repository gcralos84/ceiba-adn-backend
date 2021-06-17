package com.ceiba.citamedica.carlos.gonzalez.usuario.servicio;

import com.ceiba.citamedica.carlos.gonzalez.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.entidad.Usuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.citamedica.carlos.gonzalez.BasePrueba;

public class ServicioActualizarUsuarioTest {

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
