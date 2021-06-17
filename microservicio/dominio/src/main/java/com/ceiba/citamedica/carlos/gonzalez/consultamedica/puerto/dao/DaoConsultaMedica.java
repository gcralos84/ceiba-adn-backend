package com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.dao;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.dto.DtoConsultaMedica;

import java.util.List;

public interface DaoConsultaMedica {
    /**
     * Permite listar  los  especilistas
     * @return los especilistas
     */
    List<DtoConsultaMedica> listar();
}
