package com.ceiba.citamedica.carlos.gonzalez.consultamedica.adaptador.dao;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.dto.DtoConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.dao.DaoConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoConsultaMedicaMysql implements DaoConsultaMedica {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @SqlStatement(namespace = "consultamedica",  value =  "listar")
    private static String sqlListar;

    public DaoConsultaMedicaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoConsultaMedica> listar() {
        return  this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().query(sqlListar, new MapeoConsultaMedica());
    }
}
