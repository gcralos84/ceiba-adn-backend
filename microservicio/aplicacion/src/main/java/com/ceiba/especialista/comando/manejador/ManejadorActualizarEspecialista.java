package com.ceiba.especialista.comando.manejador;

import com.ceiba.especialista.ComandoEspecialista;
import com.ceiba.especialista.comando.fabrica.FabricaEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.servicio.ServicioActualizarEspecialista;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEspecialista  implements ManejadorComando<ComandoEspecialista> {
    
    public final FabricaEspecialista fabricaEspecialista;
    public final ServicioActualizarEspecialista servicioActualizarEspecialista;
    
    public ManejadorActualizarEspecialista(FabricaEspecialista fabricaEspecialista, ServicioActualizarEspecialista servicioActualizarEspecialista) {
        this.fabricaEspecialista = fabricaEspecialista;
        this.servicioActualizarEspecialista = servicioActualizarEspecialista;
    }
    
    public void ejecutar(ComandoEspecialista comando) {
        Especialista especialista = this.fabricaEspecialista.crear(comando);
        this.servicioActualizarEspecialista.ejecutar(especialista);
    }
}
