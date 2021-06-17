package com.ceiba.citamedica.carlos.gonzalez.especialista.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.ComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.especialista.comando.fabrica.FabricaEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad.Especialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.ServicioCrearEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.especialista.ComandoEspecialista;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEspecialista  implements ManejadorComandoRespuesta<ComandoEspecialista, ComandoRespuesta<Long>> {
    private final FabricaEspecialista fabricaEspecialista;
    private final ServicioCrearEspecialista servicioCrearEspecialista;
    
    public ManejadorCrearEspecialista(FabricaEspecialista fabricaEspecialista, ServicioCrearEspecialista servicioCrearEspecialista) {
        this.fabricaEspecialista = fabricaEspecialista;
        this.servicioCrearEspecialista = servicioCrearEspecialista;
    }
    
    public ComandoRespuesta<Long> ejecutar(ComandoEspecialista comando){
        Especialista especialista  = this.fabricaEspecialista.crear(comando);
       return new  ComandoRespuesta<>(this.servicioCrearEspecialista.ejecutar(especialista));
    }
}
