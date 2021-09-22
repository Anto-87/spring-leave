package com.srlite.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


/**
 * The application configuration to set up the database details
 * Picking the url, className, userName, password from the properties file.
 */
@Configuration
public class AppConfig {

    @Value("${spring.datasource.url}")
    private String dataSourceURL;
    
    @Value("${spring.datasource.driverClassName}")
    private String dbDriverClassName;

    @Value("${spring.datasource.username}")
    private String dbUserName;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    /**
     * Bind the datasource details and return the reference.
     * @return
     */
    @Bean 
    public DataSource dataSource(){

        final DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(dbDriverClassName);
        dataSource.setUrl(dataSourceURL);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbPassword);
        return dataSource;
        
    }
    
}
