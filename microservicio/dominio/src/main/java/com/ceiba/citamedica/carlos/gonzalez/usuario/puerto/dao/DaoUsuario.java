package com.ceiba.citamedica.carlos.gonzalez.usuario.puerto.dao;

import com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoUsuario {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoUsuario> listar();
}
