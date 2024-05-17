package com.sharanya.mds.springbootmds.configurations;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
        basePackages = "com.sharanya.mds.springbootmds.orderrepository",
        entityManagerFactoryRef = "psEntityMaanger",
        transactionManagerRef = "psTransactionManager"
)
public class PsEntityManagerConfiguration {

    LocalContainerEntityManagerFactoryBean psEntityMaanger(EntityManagerFactoryBuilder entityManagerFactoryBuilder,@Qualifier("psSqlDataSource") DataSource dataSource){

        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.sharanya.mds.springbootmds.orderentities")
                .build();
    }

    @Bean
    PlatformTransactionManager psTransactionManager(@Qualifier("psEntityMaanger") LocalEntityManagerFactoryBean emfb){
        return new JpaTransactionManager(emfb.getObject());
    }
}
