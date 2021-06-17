package com.ceiba.citamedica.carlos.gonzalez.paciente.comando.manejador;

import com.ceiba.citamedica.carlos.gonzalez.manejador.ManejadorComando;
import com.ceiba.citamedica.carlos.gonzalez.paciente.servicio.ServicioEliminarPaciente;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPaciente implements ManejadorComando<Long> {
      private  final ServicioEliminarPaciente servicioEliminarPaciente;
      public ManejadorEliminarPaciente(ServicioEliminarPaciente servicioEliminarPaciente) {
            this.servicioEliminarPaciente = servicioEliminarPaciente;
      }
      public void ejecutar(Long idpaciente){
           this.servicioEliminarPaciente.ejecutar(idpaciente);
      }
}
