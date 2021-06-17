package com.ceiba.citamedica.carlos.gonzalez.paciente.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComando;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.entidad.Paciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.servicio.ServicioActualizarPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.ComandoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.fabrica.FabricaPaciente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActulizarPaciente  implements ManejadorComando<ComandoPaciente> {
    private final FabricaPaciente fabricaPaciente;
    private final ServicioActualizarPaciente servicioActualizarPaciente;
    
    public ManejadorActulizarPaciente(FabricaPaciente fabricaPaciente, ServicioActualizarPaciente servicioActualizarPaciente) {
        this.fabricaPaciente = fabricaPaciente;
        this.servicioActualizarPaciente = servicioActualizarPaciente;
    }
    
    public void ejecutar(ComandoPaciente comandoPaciente) {
         Paciente paciente = this.fabricaPaciente.crear(comandoPaciente);
         this.servicioActualizarPaciente.ejecutar(paciente);
    }
}
