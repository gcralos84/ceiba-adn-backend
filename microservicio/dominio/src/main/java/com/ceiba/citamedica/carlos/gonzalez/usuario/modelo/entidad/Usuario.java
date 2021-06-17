package com.ceiba.citamedica.carlos.gonzalez.usuario.modelo.entidad;


import com.ceiba.citamedica.carlos.gonzalez.dominio.ValidadorArgumento;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;

    public Usuario(Long id,String nombre, String clave,LocalDateTime fechaCreacion) {
        ValidadorArgumento.validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        ValidadorArgumento.validarObligatorio(clave, SE_DEBE_INGRESAR_LA_CLAVE);
        ValidadorArgumento.validarLongitud(clave, LONGITUD_MINIMA_CLAVE, String.format(LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A,LONGITUD_MINIMA_CLAVE));
        ValidadorArgumento.validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.fechaCreacion = fechaCreacion;
    }

}
