package com.ceiba.consultamedica.modelo.entidad;

import com.ceiba.Mensage;
import com.ceiba.especialista.modelo.dto.DtoEspecialista;
import com.ceiba.paciente.modelo.dto.DtoPaciente;
import lombok.Getter;

import java.time.LocalDate;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class ConsultaMedica {
    Mensage SE_DEBE_INGRESAR_INFORMACION_ESPECILISTA = Mensage.MENSAGE_INFORMACION_ESPECIALISTA_REQUERIDO;
    Mensage SE_DEBE_INGRESAR_INFORMACION_PACIENTE = Mensage.MENSAGE_INFORMACION_PACIENTE_REQUERIDO;;
    Mensage SE_DEBE_INGRESAR_LA_FECHA_CITA  = Mensage.MENSAGE_FECHA_CITA__REQUERIDO;
    Mensage SE_DEBE_INGRESAR_EL_TIPO_USUARIO  = Mensage.MENSAGE_TIPO_USUARIO_REQUERIDO;

    private Long  id;
    private String identificacionEspecialista;
    private String identificacionPaciente;
    private LocalDate fechaCita;
    private String tipoUsuario;
    private double valorCuotaModeradora;
    
    public ConsultaMedica(Long id, String identificacionEspecialista, String identificacionPaciente,String tipoUsuario, LocalDate fechaCita) {
        validarObligatorio(identificacionEspecialista,SE_DEBE_INGRESAR_INFORMACION_ESPECILISTA.getMensage());
        validarObligatorio(identificacionPaciente,SE_DEBE_INGRESAR_INFORMACION_PACIENTE.getMensage());
        validarObligatorio(tipoUsuario,SE_DEBE_INGRESAR_EL_TIPO_USUARIO.getMensage());
        validarObligatorio(fechaCita,SE_DEBE_INGRESAR_LA_FECHA_CITA.getMensage());
        
        this.id = id;
        this.identificacionEspecialista = identificacionEspecialista;
        this.identificacionPaciente = identificacionPaciente;
        this.fechaCita = fechaCita;
        this.tipoUsuario = tipoUsuario;
        //this.valorCuotaModeradora = valorCuotaModeradora;
    }

    public void setValorCuotaModeradora(double valorCuotaModeradora) {
        this.valorCuotaModeradora = valorCuotaModeradora;
    }
}
