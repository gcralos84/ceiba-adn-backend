package com.ceiba.citamedica.carlos.gonzalez;

import lombok.Getter;

@Getter
public enum Mensage {
    MENSAGE_NOMBRE_USUARIO_REQUERIDO("Se debe ingresar el nombre de usuario"),
    MENSAGE_TIPO_USUARIO_REQUERIDO("Se debe ingresar el tipo usuario"),
    MENSAGE_IDENTIFICACION_REQUERIDO("Se debe ingresar  la identificacion"),
    MENSAGE_USUARIO_YA_RESGISTRADO("El usuario ya existe en el sistema"),
    MENSAGE_ESPECILIDA_REQUERIDO("Se debe ingresar la especialida"),
    MENSAGE_INFORMACION_ESPECIALISTA_REQUERIDO("Se debe ingresar la informacion especialista"),
    MENSAGE_INFORMACION_PACIENTE_REQUERIDO("Se debe ingresar la informacion paciente"),
    MENSAGE_FECHA_CITA__REQUERIDO("Se debe ingresar la informacion paciente"),
    MENSAGE_ESPECIALISTA_NO_ESTA_RESGISTRADO("El especialista no esta registrado"),
    MENSAGE_PACIENTE_NO_ESTA_RESGISTRADO("El paciente no esta registrado"),
    MENSAGE_FECHA_NACIMIENTO_REQUERIDO("La fecha de nacimiento es requerida"),
    MENSAGE_FECHA_NACIMIENTO_INVALIDA("La fecha de nacimiento no es validad"),
    TIPO_USUARIO_NO_VALIDO("El tipo de usuario no es valido"),
    CITA_MEDICA_NO_EXISTE("La cita  medica  no existe");
    private  String  mensage;
    
    private  Mensage(String mensage) {
        this.mensage = mensage;
    }
    
    
}
