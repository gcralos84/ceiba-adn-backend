package com.ceiba.citamedica.carlos.gonzalez.paciente.adaptador.repositorio;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.entidad.Paciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPacienteMysql  implements RepositorioPaciente {
    
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    
    @SqlStatement(namespace = "paciente",value = "crear")
    private static String sqlCrear;
    
    @SqlStatement(namespace = "paciente",value = "actualizar")
    private static String sqlActualizar;
    
    @SqlStatement(namespace = "paciente",value = "eliminar")
    private static String sqlEliminar;
    
    @SqlStatement(namespace = "paciente",value = "existe")
    private static String sqlExiste;
    
    public RepositorioPacienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    
    @Override
    public Long crear(Paciente paciente) {
        return customNamedParameterJdbcTemplate
                .crear(paciente,sqlCrear);
    }
    
    @Override
    public void actualizar(Paciente paciente) {
        this.customNamedParameterJdbcTemplate.actualizar(paciente, sqlActualizar);
    }
    
    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource  mapSqlParameter =  new MapSqlParameterSource();
        mapSqlParameter.addValue("id",id);
        this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .update(sqlEliminar,mapSqlParameter);
    }
    
    @Override
    public boolean existe(String identificacion) {
        MapSqlParameterSource  mapSqlParameter  = new MapSqlParameterSource();
        mapSqlParameter.addValue("identificacion",identificacion);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .queryForObject(sqlExiste,mapSqlParameter,Boolean.class);
    }

    @Override
    public String tipoPaciente(String identificacion) {
        return null;
    }
}
