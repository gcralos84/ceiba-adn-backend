package com.ceiba.consultamedica.servicios;

import com.ceiba.Mensage;
import com.ceiba.consultamedica.modelo.entidad.ConsultaMedica;
import com.ceiba.consultamedica.puerto.repositorio.RepositorioConsultaMedica;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.paciente.puerto.repositorio.RepositorioPaciente;

public class ServicioCrearConsultaMedica {

    private final RepositorioConsultaMedica repositorioConsultaMedica;
    private final RepositorioPaciente  repositorioPaciente;
    private final RepositorioEspecialista repositorioEspecialista;
    private final String TIPO_I = "TIPO_I";
    private final String TIPO_II = "TIPO_II";
    private final String TIPO_III = "TIPO_III";
    Mensage EL_ESPECILISTA_NO_SE_ENCUENTRA_REGISTRADO  =  Mensage.MENSAGE_ESPECIALISTA_NO_ESTA_RESGISTRADO;
    Mensage EL_PACIENTE_NO_ESTA_REGISTRADO  =  Mensage.MENSAGE_PACIENTE_NO_ESTA_RESGISTRADO;
    Mensage El_TIPO_USUARIO_NO_ES_VALIDO = Mensage.TIPO_USUARIO_NO_VALIDO;
    
    public ServicioCrearConsultaMedica(RepositorioConsultaMedica repositorioConsultaMedica,
                                       RepositorioPaciente repositorioPaciente,
                                       RepositorioEspecialista repositorioEspecialista) {
        
        this.repositorioConsultaMedica = repositorioConsultaMedica;
        this.repositorioPaciente = repositorioPaciente;
        this.repositorioEspecialista = repositorioEspecialista;
    }
    public Long ejecutar(ConsultaMedica consultamMedica){
        validarExistenciaPaciente(consultamMedica);
        validarExistenciaEspecialista(consultamMedica);
        consultamMedica.setValorCuotaModeradora(cuoataModeradora(consultamMedica.getTipoUsuario()));
        return this.repositorioConsultaMedica.crear(consultamMedica);
    }

    private void validarExistenciaPaciente(ConsultaMedica consultamMedica) {
        boolean  existe = repositorioPaciente.existe(consultamMedica.getIdentificacionPaciente());
        if(!existe)
            throw  new ExcepcionDuplicidad(EL_PACIENTE_NO_ESTA_REGISTRADO.getMensage());
    }
    
    private void validarExistenciaEspecialista(ConsultaMedica consultamMedica) {
         boolean existe =  this.repositorioEspecialista.existe(consultamMedica.getIdentificacionEspecialista());
         if(!existe)
             throw new ExcepcionDuplicidad(EL_ESPECILISTA_NO_SE_ENCUENTRA_REGISTRADO.getMensage());
    }
    public   double  cuoataModeradora(String  tipoUsuario){
        double SMLDV  = 30284;
        double montoCuoataModeradora = 0;
           switch (tipoUsuario){
               case TIPO_I:
                   montoCuoataModeradora = SMLDV*0.1170;
                   break;
               case TIPO_II:
                   montoCuoataModeradora = SMLDV*0.4610;
                   break;
               case  TIPO_III:
                   montoCuoataModeradora = SMLDV*1.251;
                   break;
               default:
                    throw  new ExcepcionValorInvalido(El_TIPO_USUARIO_NO_ES_VALIDO.getMensage());
           }
        return montoCuoataModeradora;
    }
}
