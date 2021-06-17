package com.ceiba.citamedica.carlos.gonzalez.especialista.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.ServicioEliminarEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManajadorEliminarEspecialista implements ManejadorComando<Long> {
    private final ServicioEliminarEspecialista servicioEliminarEspecialista;
    
    public ManajadorEliminarEspecialista(ServicioEliminarEspecialista servicioEliminarEspecialista) {
        this.servicioEliminarEspecialista = servicioEliminarEspecialista;
    }
    
    @Override
    public void ejecutar(Long id) {
        this.servicioEliminarEspecialista.ejecutar(id);
    }
}
