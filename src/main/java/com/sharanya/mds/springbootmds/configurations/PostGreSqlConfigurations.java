package com.sharanya.mds.springbootmds.configurations;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PostGreSqlConfigurations {

    @ConfigurationProperties("spring.datasource.ps")
    @Bean
    public DataSourceProperties psSqlDataProperties(){
        return new DataSourceProperties();
    }


    @Primary
    @Bean
    public DataSource psSqlDataSource(){
        return psSqlDataProperties().initializeDataSourceBuilder().build();
    }
}
