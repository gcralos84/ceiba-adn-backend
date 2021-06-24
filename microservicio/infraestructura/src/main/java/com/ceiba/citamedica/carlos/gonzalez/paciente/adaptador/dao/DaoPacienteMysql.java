package com.ceiba.citamedica.carlos.gonzalez.paciente.adaptador.dao;

import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoDetalleConsulta;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.dao.DaoPaciente;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoPacienteMysql  implements DaoPaciente {
    private  final CustomNamedParameterJdbcTemplate  customNamedParameterJdbcTemplate;
    @SqlStatement(namespace = "paciente", value = "listar")
    private  static  String sqlListar;
    
    @SqlStatement(namespace = "paciente", value = "detalle_paciente")
    private  static  String sqlDetallePaciente;
    
    @SqlStatement(namespace = "paciente", value = "historial_consultamedicas")
    private  static  String sqlHistorialConsultaMediacas;
    
    public DaoPacienteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    
    @Override
    public List<DtoPaciente> listar() {
        return  this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(sqlListar, new MapeoPaciente());
    }
    
    @Override
    public List<DtoPaciente> detallePaciente(String id) {
        MapSqlParameterSource mapSqlParameterSource  = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("identificacion",id);
        return  this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(sqlDetallePaciente,mapSqlParameterSource,new MapeoPaciente());
    }
    
    @Override
    public List<DtoDetalleConsulta> detalleConsulta() {
        return  this.customNamedParameterJdbcTemplate
                .getNamedParameterJdbcTemplate()
                .query(sqlHistorialConsultaMediacas, new MapeoDetalleconsulta());
    }
}
