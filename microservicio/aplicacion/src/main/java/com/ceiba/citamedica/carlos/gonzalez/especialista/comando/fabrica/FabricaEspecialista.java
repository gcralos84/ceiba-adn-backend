package com.ceiba.citamedica.carlos.gonzalez.especialista.comando.fabrica;

import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad.Especialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.ComandoEspecialista;
import org.springframework.stereotype.Component;

@Component
public class FabricaEspecialista {
     public Especialista crear(ComandoEspecialista  comandoEspecialista){
        return new Especialista(
                comandoEspecialista.getId(),
                comandoEspecialista.getIdentificacion(),
                comandoEspecialista.getNombre(),
                comandoEspecialista.getEspecialidad()
        );
     }
}
