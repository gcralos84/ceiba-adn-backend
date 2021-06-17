package com.ceiba.citamedica.carlos.gonzalez.paciente.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.ComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComandoRespuesta;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.entidad.Paciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.servicio.ServicioCrearPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.ComandoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.fabrica.FabricaPaciente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPaciente  implements ManejadorComandoRespuesta<ComandoPaciente, ComandoRespuesta<Long>> {
    private  final FabricaPaciente fabricaPaciente;
    private final ServicioCrearPaciente servicioCrearPaciente;
    
    public ManejadorCrearPaciente(FabricaPaciente fabricaPaciente, ServicioCrearPaciente servicioCrearPaciente) {
        this.fabricaPaciente = fabricaPaciente;
        this.servicioCrearPaciente = servicioCrearPaciente;
    }
    
    public ComandoRespuesta<Long> ejecutar(ComandoPaciente comando) {
        Paciente paciente  = this.fabricaPaciente.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearPaciente.ejecutar(paciente));
    }
}
