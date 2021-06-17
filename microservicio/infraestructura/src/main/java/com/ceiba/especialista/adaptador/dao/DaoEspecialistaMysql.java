package com.ceiba.especialista.adaptador.dao;

import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.especialista.puerto.dao.DaoEspecialista;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
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
