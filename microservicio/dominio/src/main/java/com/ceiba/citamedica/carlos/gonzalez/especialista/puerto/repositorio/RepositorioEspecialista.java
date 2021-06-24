package com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.repositorio;


import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad.Especialista;

import java.util.List;

public interface RepositorioEspecialista {
    /**
     * Permite crear un  especialista
     * @param  especialista
     * @return el id generado
     */
     Long crear(Especialista especialista);
    
    /**
     * Permite actualizar un especialista
     * @param especialista
     */
    void actualizar(Especialista especialista);
    
    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);
    
    /**
     * Permite validar si existe un  especialista con el numero de identificacion
     * @param identificacion
     * @return si existe o no
     */
    boolean existe(String identificacion);
    
   
}
