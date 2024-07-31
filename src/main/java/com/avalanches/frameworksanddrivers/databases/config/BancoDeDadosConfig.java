package com.avalanches.frameworksanddrivers.databases.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class BancoDeDadosConfig {

    @Autowired
    private Environment ambiente;

    @Bean
    public DataSource OrigemDados() {
        DriverManagerDataSource origemDados = new DriverManagerDataSource();
        origemDados.setDriverClassName(ambiente.getProperty("spring.datasource.driver-class-name"));
        origemDados.setUrl(ambiente.getProperty("spring.datasource.url"));
        origemDados.setUsername(ambiente.getProperty("spring.datasource.username"));
        origemDados.setPassword(ambiente.getProperty("spring.datasource.password"));
        return origemDados;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource origemDados) {
        return new JdbcTemplate(origemDados);
    }
}