package com.ceiba.citamedica.carlos.gonzalez.usuario.comando.fabrica;

import com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

import com.ceiba.citamedica.carlos.gonzalez.usuario.comando.ComandoUsuario;

@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario) {
        return new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getNombre(),
                comandoUsuario.getClave(),
                comandoUsuario.getFecha()
        );
    }

}
