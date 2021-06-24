package com.ceiba.citamedica.carlos.gonzalez.paciente.adaptador.dao;

import com.ceiba.citamedica.carlos.gonzalez.infraestructura.jdbc.MapperResult;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoDetalleConsulta;
import com.ceiba.citamedica.carlos.gonzalez.paciente.modelo.dto.DtoPaciente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class MapeoDetalleconsulta  implements RowMapper<DtoDetalleConsulta>, MapperResult {
    
    @Override
    public DtoDetalleConsulta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        String identificacion = resultSet.getString("identificacion");
        String nombre = resultSet.getString("nombre");
        String  nombreEspecialista = resultSet.getString("nombreEspecialista");
        String  especialidad = resultSet.getString("especialidad");
        LocalTime horaCita = LocalTime.from(extraerLocalDateTime(resultSet,"horaCita"));
        LocalDate fechaCita =  extraerLocalDate(resultSet,"fechaCita");
        double cuoataModeradora = resultSet.getDouble("cuoataModeradora");
        return new DtoDetalleConsulta(identificacion,nombre,nombreEspecialista,especialidad,horaCita,fechaCita,cuoataModeradora);
     
    }
}

