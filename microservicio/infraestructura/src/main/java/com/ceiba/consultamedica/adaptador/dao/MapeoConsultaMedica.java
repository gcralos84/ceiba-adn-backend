package com.ceiba.consultamedica.adaptador.dao;

import com.ceiba.consultamedica.modelo.dto.DtoConsultaMedica;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoConsultaMedica  implements RowMapper<DtoConsultaMedica>, MapperResult {

    @Override
    public DtoConsultaMedica mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String identificacionEspecialista   = resultSet.getString("identificacionEspecialista");
        String identificacionPaciente = resultSet.getString("identificacionPaciente;");
        Date fechaCita  =  resultSet.getDate("fechaCita");
        String tipoUsuario =  resultSet.getString("tipoUsuario");
        return  new  DtoConsultaMedica( id, identificacionEspecialista,identificacionPaciente,fechaCita,tipoUsuario);
    }
}
