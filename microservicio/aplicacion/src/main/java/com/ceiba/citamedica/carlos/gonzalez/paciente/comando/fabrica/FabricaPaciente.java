package com.ceiba.citamedica.carlos.gonzalez.paciente.comando.fabrica;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.entidad.Paciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.comando.ComandoPaciente;
import org.springframework.stereotype.Component;

@Component
public class FabricaPaciente {
    
    public Paciente crear(ComandoPaciente comandoPaciente){
        return  new Paciente(
                comandoPaciente.getId(),
                comandoPaciente.getIdentificacion(),
                comandoPaciente.getNombre(),
                comandoPaciente.getTipoUsuario(),
                comandoPaciente.getFechaNacimiento());
    }
}
