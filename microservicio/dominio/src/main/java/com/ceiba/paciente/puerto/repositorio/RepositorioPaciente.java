package com.ceiba.paciente.puerto.repositorio;

import com.ceiba.paciente.modelo.entidad.Paciente;

public interface RepositorioPaciente {
    /**
     * Permite crear un usuario
     * @param  paciente
     * @return el id generado
     */
     Long crear(Paciente paciente);
    
    /**
     * Permite actualizar un usuario
     * @param paciente
     * @return
     */
    void actualizar(Paciente paciente);
    
    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);
    
    /**
     * Permite validar si existe un paciente  con el numero de identificacion
     * @param identificacion
     * @return si existe o no
     */
    boolean existe(String identificacion);

    String tipoPaciente( String  identificacion);
    
    
}
