package com.sharanya.mds.springbootmds.configurations;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MySQLDataConfigurations {


    @ConfigurationProperties("spring.datasource.mysql")
    @Bean
    public DataSourceProperties mySqlDataProperties(){

        return  new DataSourceProperties();
    }


    @Bean
    public DataSource mySqlDataSource(){

        /*DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(mySqlDataProperties().getUsername());
        dataSource.setPassword(mySqlDataProperties().getPassword());
        dataSource.setDriverClassName(mySqlDataProperties().getDriverClassName());
        dataSource.setUrl(mySqlDataProperties().getUrl());
        return dataSource;*/

        return mySqlDataProperties().initializeDataSourceBuilder().build();
    }
}
