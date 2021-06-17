package com.ceiba.citamedica.carlos.gonzalez.usuario.servicio;

import com.ceiba.citamedica.carlos.gonzalez.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long id) {
       this.repositorioUsuario.eliminar(id);
    }
}
