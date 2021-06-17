package com.ceiba.citamedica.carlos.gonzalez.usuario.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComando;
import com.ceiba.citamedica.carlos.gonzalez.usuario.comando.fabrica.FabricaUsuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.entidad.Usuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.comando.ComandoUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarUsuario implements ManejadorComando<ComandoUsuario> {

    private final FabricaUsuario fabricaUsuario;
    private final ServicioActualizarUsuario servicioActualizarUsuario;

    public ManejadorActualizarUsuario(FabricaUsuario fabricaUsuario, ServicioActualizarUsuario servicioActualizarUsuario) {
        this.fabricaUsuario = fabricaUsuario;
        this.servicioActualizarUsuario = servicioActualizarUsuario;
    }
    
    
    @Override
    public void ejecutar(ComandoUsuario comando) {
        Usuario usuario = this.fabricaUsuario.crear(comando);
        this.servicioActualizarUsuario.ejecutar(usuario);
    }
}
