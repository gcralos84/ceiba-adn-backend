package com.ceiba.especialista.puerto.dao;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;

import java.util.List;

public interface DaoEspecialista {
    /**
     * Permite listar  los  especilistas
     * @return los especilistas
     */
    List<DtoEspecialista> listar();
}
