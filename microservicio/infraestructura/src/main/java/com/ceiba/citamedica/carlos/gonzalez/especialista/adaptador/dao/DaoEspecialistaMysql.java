package com.ceiba.citamedica.carlos.gonzalez.especialista.adaptador.dao;

import com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.dao.DaoEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DaoEspecialistaMysql implements DaoEspecialista {
    private final CustomNamedParameterJdbcTemplate  customNamedParameterJdbcTemplate;
    @SqlStatement(namespace = "especialista",value = "listar")
    private  static  String sqlListar;
    
    public DaoEspecialistaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    
    @Override
    public List<DtoEspecialista> listar() {
        return this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEspecialista());
    }
}
