package com.ceiba.citamedica.carlos.gonzalez.consultamedica.adaptador.dao;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.dto.DtoConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoConsultaMedica  implements RowMapper<DtoConsultaMedica>, MapperResult {

    @Override
    public DtoConsultaMedica mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String identificacionEspecialista   = resultSet.getString("identificacionEspecialista");
        String identificacionPaciente = resultSet.getString("identificacionPaciente");
        Date fechaCita  =  resultSet.getDate("fechaCita");
        String tipoUsuario =  resultSet.getString("tipoUsuario");
        return  new  DtoConsultaMedica( id, identificacionEspecialista,identificacionPaciente,fechaCita,tipoUsuario);
    }
}
