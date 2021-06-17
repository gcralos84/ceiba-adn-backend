package com.ceiba.paciente.adaptador.dao;


import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoPaciente implements RowMapper<DtoPaciente>, MapperResult {
    @Override
    public DtoPaciente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long  id  =  resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String identificacion = resultSet.getString("identificacion");
        String  tipoUsuario = resultSet.getString("tipoUsuario");
        LocalDate fechaNacimiento =  extraerLocalDate(resultSet,"fechaNacimiento");
        return new DtoPaciente(id,identificacion,nombre,tipoUsuario,fechaNacimiento);
    }
}
