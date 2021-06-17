package com.ceiba.consultamedica.puerto.dao;

import com.ceiba.consultamedica.modelo.dto.DtoConsultaMedica;

import java.util.List;

public interface DaoConsultaMedica {
    /**
     * Permite listar  los  especilistas
     * @return los especilistas
     */
    List<DtoConsultaMedica> listar();
}
