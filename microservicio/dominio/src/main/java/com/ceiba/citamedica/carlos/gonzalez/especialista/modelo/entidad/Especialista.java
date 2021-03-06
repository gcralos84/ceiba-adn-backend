package com.ceiba.citamedica.carlos.gonzalez.especialista.modelo.entidad;

import com.ceiba.citamedica.carlos.gonzalez.Mensage;
import lombok.Getter;

import static com.ceiba.citamedica.carlos.gonzalez.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Especialista {
    private static final Mensage SE_DEBE_INGRESAR_IDENTIFICACION_USUARIO = Mensage.MENSAGE_IDENTIFICACION_REQUERIDO;
    private static final Mensage SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = Mensage.MENSAGE_NOMBRE_USUARIO_REQUERIDO;
    private static final Mensage SE_DEBE_INGREZAR_LA_ESPECILIDAD  = Mensage.MENSAGE_ESPECILIDA_REQUERIDO;
    
    private Long  id;
    private String identificacion;
    private String nombre;
    private String especialidad;
    private Boolean active;
    
    public Especialista(Long id, String identificacion, String nombre, String especialidad,boolean active) {
        validarObligatorio(identificacion,SE_DEBE_INGRESAR_IDENTIFICACION_USUARIO.getMensage());
        validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO.getMensage());
        validarObligatorio(especialidad,SE_DEBE_INGREZAR_LA_ESPECILIDAD.getMensage());
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.active = active;
    }
}
