package com.ceiba.citamedica.carlos.gonzalez.consultamedica.comando.fabrica;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.ComandoConsultaMedica;
import org.springframework.stereotype.Component;

@Component
public class FabricaConsultaMedica {
      public ConsultaMedica crear(ComandoConsultaMedica comandoConsultaMedica){
          return  new ConsultaMedica(
                  comandoConsultaMedica.getId(),
                  comandoConsultaMedica.getIdentificacionEspecialista(),
                  comandoConsultaMedica.getIdentificacionPaciente(),
                  comandoConsultaMedica.getHoraCita(),
                  comandoConsultaMedica.getFechaCita(),
                  comandoConsultaMedica.getTipoUsuario(),
                  comandoConsultaMedica.getActive()
                  );
      }
}
