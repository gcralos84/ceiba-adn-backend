package com.ceiba.paciente.modelo.entidad;

import com.ceiba.Mensage;
import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarFechaNacimineto;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Paciente {
    Mensage SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = Mensage.MENSAGE_NOMBRE_USUARIO_REQUERIDO;
    Mensage SE_DEBE_INGRESAR_EL_TIPO_DE_USUARIO = Mensage.MENSAGE_TIPO_USUARIO_REQUERIDO;
    Mensage SE_DEBE_INGRESAR_IDENTIFICACION_USUARIO = Mensage.MENSAGE_IDENTIFICACION_REQUERIDO;
    Mensage SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO = Mensage.MENSAGE_FECHA_NACIMIENTO_REQUERIDO;
    Mensage SE_DEBE_INGRESAR_UNA_FECHA_VALIDA= Mensage.MENSAGE_FECHA_NACIMIENTO_INVALIDA;

    private  Long  id;
    private  String  nombre;
    private  String identificacion;
    private  String  tipoUsuario;
    private LocalDate fechaNacimiento;
    
    public Paciente(Long id, String identificacion, String nombre, String tipoUsuario, LocalDate fechaNacimiento) {
        validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO.getMensage());
        validarObligatorio(identificacion,SE_DEBE_INGRESAR_IDENTIFICACION_USUARIO.getMensage());
        validarObligatorio(tipoUsuario,SE_DEBE_INGRESAR_EL_TIPO_DE_USUARIO.getMensage());
        validarObligatorio(fechaNacimiento,SE_DEBE_INGRESAR_LA_FECHA_NACIMIENTO.getMensage());
        validarFechaNacimineto(fechaNacimiento,SE_DEBE_INGRESAR_UNA_FECHA_VALIDA.getMensage() );
        this.id = id;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
