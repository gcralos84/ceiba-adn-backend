package com.ceiba.citamedica.carlos.gonzalez.usuario.servicio;

import com.ceiba.citamedica.carlos.gonzalez.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.entidad.Usuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarUsuario {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Usuario usuario) {
        validarExistenciaPrevia(usuario);
        this.repositorioUsuario.actualizar(usuario);
    }

    private void validarExistenciaPrevia(Usuario usuario) {
        boolean existe = this.repositorioUsuario.existeExcluyendoId(usuario.getId(),usuario.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
