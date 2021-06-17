package com.ceiba.citamedica.carlos.gonzalez.consultamedica.adaptador.repositorio;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.repositorio.RepositorioConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioConsultaMedicaMysql  implements RepositorioConsultaMedica {
    private  final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioConsultaMedicaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @SqlStatement(namespace="consultamedica", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="consultamedica", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="consultamedica", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="consultamedica", value="existe")
    private static String sqlExiste;


    @Override
    public Long crear(ConsultaMedica consultaMedica) {
        return this.customNamedParameterJdbcTemplate.crear(consultaMedica,sqlCrear);
    }

    @Override
    public void actualizar(ConsultaMedica consultaMedica) {
             this.customNamedParameterJdbcTemplate.actualizar(consultaMedica,sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource mapSqlParameterSource  = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id",id);
        this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().update(sqlEliminar,mapSqlParameterSource);

    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource mapSqlParameterSource  = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("id",id);

        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().queryForObject(sqlExiste,mapSqlParameterSource,Boolean.class);
    }
}
