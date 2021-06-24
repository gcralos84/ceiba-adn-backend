package com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.repositorio;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad.ConsultaMedica;

public interface RepositorioConsultaMedica {
    /**
     * Permite crear un  consulta medica
     * @param  consultaMedica
     * @return el id generado
     */
    Long crear(ConsultaMedica consultaMedica);
    
    /**
     * Permite actualizar un consulta medica
     * @param consultaMedica
     */
    void actualizar(ConsultaMedica consultaMedica);
    
    /**
     * Permite eliminar un consulta medica
     * @param id
     */
    void eliminar(Long id);
    
    /**
     * Permite validar si existe un  consulta medica
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);
    


}
