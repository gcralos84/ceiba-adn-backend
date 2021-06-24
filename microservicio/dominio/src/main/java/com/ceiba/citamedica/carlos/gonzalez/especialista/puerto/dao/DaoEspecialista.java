package com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.dao;

import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.dto.DtoEspecialista;

import java.util.List;

public interface DaoEspecialista {
    /**
     * Permite listar  los  especilistas
     * @return los especilistas
     */
    List<DtoEspecialista> listar();
    List<DtoEspecialista> consultarAgenda(String fechaCita, String horaCita);

}
