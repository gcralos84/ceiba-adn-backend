package com.ceiba.especialista.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.especialista.ComandoEspecialista;
import com.ceiba.especialista.comando.fabrica.FabricaEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.servicio.ServicioCrearEspecialista;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEspecialista  implements ManejadorComandoRespuesta<ComandoEspecialista, ComandoRespuesta<Long>> {
    private final FabricaEspecialista fabricaEspecialista;
    private final ServicioCrearEspecialista  servicioCrearEspecialista;
    
    public ManejadorCrearEspecialista(FabricaEspecialista fabricaEspecialista, ServicioCrearEspecialista servicioCrearEspecialista) {
        this.fabricaEspecialista = fabricaEspecialista;
        this.servicioCrearEspecialista = servicioCrearEspecialista;
    }
    
    public ComandoRespuesta<Long> ejecutar(ComandoEspecialista comando){
        Especialista especialista  = this.fabricaEspecialista.crear(comando);
       return new  ComandoRespuesta<>(this.servicioCrearEspecialista.ejecutar(especialista));
    }
}
