package com.ceiba.citamedica.carlos.gonzalez.configuracion;

import com.ceiba.citamedica.carlos.gonzalez.consultamedica.puerto.repositorio.RepositorioConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios.ServicioActulizarCitaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios.ServicioCrearConsultaMedica;
import com.ceiba.citamedica.carlos.gonzalez.consultamedica.servicios.ServicioEliminarCitaMedica;
import com.ceiba.citamedica.carlos.gonzalez.especialista.puerto.repositorio.RepositorioEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.ServicioActualizarEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.ServicioCrearEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.especialista.servicio.ServicioEliminarEspecialista;
import com.ceiba.citamedica.carlos.gonzalez.paciente.puerto.repositorio.RepositorioPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.servicio.ServicioActualizarPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.servicio.ServicioCrearPaciente;
import com.ceiba.citamedica.carlos.gonzalez.paciente.servicio.ServicioEliminarPaciente;
import com.ceiba.citamedica.carlos.gonzalez.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.citamedica.carlos.gonzalez.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
    @Bean
    public ServicioCrearPaciente servicioRegistrarPaciente(RepositorioPaciente repositorioPaciente){
         return  new ServicioCrearPaciente(repositorioPaciente);
    }
    @Bean
    public ServicioActualizarPaciente servicioActualizarPaciente(RepositorioPaciente repositorioPaciente){
        return   new ServicioActualizarPaciente(repositorioPaciente);
    }
    @Bean
    public ServicioEliminarPaciente servicioEliminarPaciente(RepositorioPaciente repositorioPaciente){
        return new ServicioEliminarPaciente(repositorioPaciente);
    }
    @Bean
    public ServicioCrearEspecialista servicioCrearEspecialista(RepositorioEspecialista repositorioEspecialista){
         return new ServicioCrearEspecialista(repositorioEspecialista);
    }
    @Bean
    public ServicioActualizarEspecialista servicioActualizarEspecialista(RepositorioEspecialista repositorioEspecialista){
         return  new ServicioActualizarEspecialista(repositorioEspecialista);
    }
    @Bean
    public ServicioEliminarEspecialista servicioEliminarEspecialista(RepositorioEspecialista repositorioEspecialista){
        return new ServicioEliminarEspecialista(repositorioEspecialista);
    }
    @Bean
    public ServicioCrearConsultaMedica servicioCrearConsultaMedica(
            RepositorioConsultaMedica repositorioConsultaMedica,
            RepositorioPaciente repositorioPaciente,
            RepositorioEspecialista repositorioEspecialista){
         return new ServicioCrearConsultaMedica(repositorioConsultaMedica,repositorioPaciente,repositorioEspecialista);
    }
    @Bean
    public ServicioActulizarCitaMedica servicioActulizarCitaMedica(RepositorioConsultaMedica repositorioConsultaMedica){
        return new ServicioActulizarCitaMedica(repositorioConsultaMedica);
    }
    @Bean
    public ServicioEliminarCitaMedica servicioEliminarCitaMedica(RepositorioConsultaMedica repositorioConsultaMedica){
         return new ServicioEliminarCitaMedica(repositorioConsultaMedica);
    }
    
}
