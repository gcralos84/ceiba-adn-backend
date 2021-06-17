package com.ceiba.consultamedica.consulta;

import com.ceiba.consultamedica.modelo.dto.DtoConsultaMedica;
import com.ceiba.consultamedica.puerto.dao.DaoConsultaMedica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarConsultaMedica {
    private final DaoConsultaMedica   daoConsultaMedica;

    public ManejadorListarConsultaMedica(DaoConsultaMedica daoConsultaMedica) {
        this.daoConsultaMedica = daoConsultaMedica;
    }
    public List<DtoConsultaMedica> ejecutar(){
        return this.daoConsultaMedica.listar();
    }
}
