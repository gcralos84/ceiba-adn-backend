package com.ceiba.citamedica.carlos.gonzalez.especialista.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.especialista.comando.fabrica.FabricaEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad.Especialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.ServicioActualizarEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComando;
import com.ceiba.citamedica.carlos.gonzalez.especialista.ComandoEspecialista;
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
