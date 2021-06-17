package com.ceiba.especialista.adaptador.repositorio;

import com.ceiba.especialista.modelo.entidad.Especialista;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEspecialsitaMysql  implements RepositorioEspecialista {
    
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    
    @SqlStatement(namespace="especialista", value="crear")
    private static String sqlCrear;
    
    @SqlStatement(namespace="especialista", value="actualizar")
    private static String sqlActualizar;
    
    @SqlStatement(namespace="especialista", value="eliminar")
    private static String sqlEliminar;
    
    @SqlStatement(namespace="especialista", value="existe")
    private static String sqlExiste;
    
    public RepositorioEspecialsitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    
    @Override
    public Long crear(Especialista especialista) {
        return  this.customNamedParameterJdbcTemplate.crear(especialista, sqlCrear);
    }
    
    @Override
    public void actualizar(Especialista especialista) {
      this.customNamedParameterJdbcTemplate.actualizar(especialista,sqlActualizar);
    }
    
    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource mapSqlParameterSource  = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("identificacion",id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .update(sqlEliminar,mapSqlParameterSource);
    }
    
    @Override
    public boolean existe(String identificacion) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("identificacion",identificacion);
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlExiste,mapSqlParameterSource,Boolean.class);
    }
}
