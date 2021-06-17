package com.ceiba.consultamedica.comando.fabrica;

import com.ceiba.consultamedica.ComandoConsultaMedica;
import com.ceiba.consultamedica.modelo.entidad.ConsultaMedica;
import org.springframework.stereotype.Component;

@Component
public class FabricaConsultaMedica {
      public ConsultaMedica crear(ComandoConsultaMedica comandoConsultaMedica){
          return  new ConsultaMedica(
                  comandoConsultaMedica.getId(),
                  comandoConsultaMedica.getIdentificacionEspecialista(),
                  comandoConsultaMedica.getIdentificacionPaciente(),
                  comandoConsultaMedica.getTipoUsuario(),
                  comandoConsultaMedica.getFechaCita()
                  );
      }
}
