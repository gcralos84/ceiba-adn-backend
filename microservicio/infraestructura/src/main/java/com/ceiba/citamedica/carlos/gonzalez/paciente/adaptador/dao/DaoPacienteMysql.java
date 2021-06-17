package com.ceiba.citamedica.carlos.gonzalez.paciente.adaptador.dao;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.dao.DaoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPacienteMysql  implements DaoPaciente {
    private  final CustomNamedParameterJdbcTemplate  customNamedParameterJdbcTemplate;
    @SqlStatement(namespace = "paciente", value = "listar")
    private  static  String sqlListar;
    
    public DaoPacienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    
    @Override
    public List<DtoPaciente> listar() {
        return  this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(sqlListar, new MapeoPaciente());
    }
}
