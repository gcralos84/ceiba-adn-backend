package com.ceiba.citamedica.carlos.gonzalez.infraestructura.configuracion;

import javax.sql.DataSource;

import com.ceiba.citamedica.carlos.gonzalez.infraestructura.actuator.DataSourceHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionHealth {
	
	
	private final  DataSource dataSource;
	
	
	public ConfiguracionHealth(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Bean
    public DataSourceHealthIndicator dataSourceHealthIndicator() {
		return new DataSourceHealthIndicator(this.dataSource);
       
    } 

}
