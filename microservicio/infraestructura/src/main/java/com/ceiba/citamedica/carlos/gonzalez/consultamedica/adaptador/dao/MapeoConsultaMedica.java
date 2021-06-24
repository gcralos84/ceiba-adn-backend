package com.ceiba.citamedica.carlos.gonzalez.consultamedica.adaptador.dao;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.modelo.dto.DtoConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class MapeoConsultaMedica  implements RowMapper<DtoConsultaMedica>, MapperResult {

    @Override
    public DtoConsultaMedica mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String identificacionEspecialista   = resultSet.getString("identificacionEspecialista");
        String identificacionPaciente = resultSet.getString("identificacionPaciente");
        LocalTime horaCita = LocalTime.from(extraerLocalDateTime(resultSet,"horaCita"));;
        LocalDate fechaCita  =  extraerLocalDate(resultSet,"fechaCita");
        String tipoUsuario =  resultSet.getString("tipoUsuario");
        double cuoataModeradora  =  resultSet.getDouble("cuoataModeradora");
        return  new  DtoConsultaMedica( id, identificacionEspecialista,identificacionPaciente,horaCita,fechaCita,tipoUsuario,cuoataModeradora);
    }
}
