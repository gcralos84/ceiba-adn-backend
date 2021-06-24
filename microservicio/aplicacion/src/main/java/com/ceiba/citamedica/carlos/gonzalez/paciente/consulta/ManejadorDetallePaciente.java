package com.ceiba.citamedica.carlos.gonzalez.paciente.consulta;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.dao.DaoPaciente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorDetallePaciente {
    private final DaoPaciente daoPaciente;
    
    public ManejadorDetallePaciente(DaoPaciente daoPaciente) {
        this.daoPaciente = daoPaciente;
    }
    public List<DtoPaciente> ejecutar( String id){
        return this.daoPaciente.detallePaciente(id);
    }
}
