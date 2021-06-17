package com.ceiba.citamedica.carlos.gonzalez.consultamedica.consulta;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.dto.DtoConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.dao.DaoConsultaMedica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarConsultaMedica {
    private final DaoConsultaMedica daoConsultaMedica;

    public ManejadorListarConsultaMedica(DaoConsultaMedica daoConsultaMedica) {
        this.daoConsultaMedica = daoConsultaMedica;
    }
    public List<DtoConsultaMedica> ejecutar(){
        return this.daoConsultaMedica.listar();
    }
}
