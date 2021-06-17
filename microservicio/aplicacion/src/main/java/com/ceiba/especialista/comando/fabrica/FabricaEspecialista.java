package com.ceiba.especialista.comando.fabrica;

import com.ceiba.especialista.ComandoEspecialista;
import com.ceiba.especialista.modelo.entidad.Especialista;
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
