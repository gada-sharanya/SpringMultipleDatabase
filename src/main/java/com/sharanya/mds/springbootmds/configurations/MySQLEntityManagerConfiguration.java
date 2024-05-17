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

@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
        basePackages = "com.sharanya.mds.springbootmds.productrepoistory",
        entityManagerFactoryRef = "mySqlEntityManager",
        transactionManagerRef = "mySqlTransactionManager"
)
public class MySQLEntityManagerConfiguration {

    @Bean
    LocalContainerEntityManagerFactoryBean mySqlEntityManager(EntityManagerFactoryBuilder entityManagerFactoryBuilder,@Qualifier("mySqlDataSource") DataSource dataSource){

        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.sharanya.mds.springbootmds.productentities")
                .build();

    }

    @Bean
    PlatformTransactionManager mySqlTransactionManager(@Qualifier("mySqlEntityManager") LocalEntityManagerFactoryBean emfb){

        return new JpaTransactionManager(emfb.getObject());
    }


}
