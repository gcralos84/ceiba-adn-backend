package com.ceiba.citamedica.carlos.gonzalez.usuario.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.ComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.entidad.Usuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.servicio.ServicioCrearUsuario;
import org.springframework.stereotype.Component;

import com.ceiba.citamedica.carlos.gonzalez.usuario.comando.ComandoUsuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.comando.fabrica.FabricaUsuario;

@Component
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoUsuario, ComandoRespuesta<Long>> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioCrearUsuario servicioCrearUsuario;

    public ManejadorCrearUsuario(FabricaUsuario fabricaUsuario, ServicioCrearUsuario servicioCrearUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioCrearUsuario = servicioCrearUsuario;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoUsuario comandoUsuario) {
        Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
        return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(usuario));
    }
}
