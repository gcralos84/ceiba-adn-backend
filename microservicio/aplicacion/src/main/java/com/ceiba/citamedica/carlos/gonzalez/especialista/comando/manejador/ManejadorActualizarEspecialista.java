package com.ceiba.citamedica.carlos.gonzalez.especialista.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.especialista.comando.fabrica.FabricaEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad.Especialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.ServicioActualizarEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComando;
import com.ceiba.citamedica.carlos.gonzalez.especialista.ComandoEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComandoActulizar;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEspecialista  implements ManejadorComandoActulizar<ComandoEspecialista,String> {
    
    public final FabricaEspecialista fabricaEspecialista;
    public final ServicioActualizarEspecialista servicioActualizarEspecialista;
    
    public ManejadorActualizarEspecialista(FabricaEspecialista fabricaEspecialista, ServicioActualizarEspecialista servicioActualizarEspecialista) {
        this.fabricaEspecialista = fabricaEspecialista;
        this.servicioActualizarEspecialista = servicioActualizarEspecialista;
    }
    
    public void ejecutar(ComandoEspecialista comando, String id) {
        Especialista especialista = this.fabricaEspecialista.crear(comando);
        this.servicioActualizarEspecialista.ejecutar(especialista,id);
    }
}
