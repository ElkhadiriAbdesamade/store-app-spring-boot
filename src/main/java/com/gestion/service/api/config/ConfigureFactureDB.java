package com.gestion.service.api.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        transactionManagerRef = "factureTransactionManager",
        entityManagerFactoryRef = "factureEntityManagerFactory",
        basePackages = {"com.gestion.service.api.dataaccess.facture.dao"}
)
public class ConfigureFactureDB {

    @Bean(name="factureDSProps")
    @ConfigurationProperties("facture.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean(name = "factureDataSource")
    @ConfigurationProperties(prefix = "facture.datasource")
    public DataSource dataSource(@Qualifier("factureDSProps") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "factureEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean factureEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("factureDataSource") DataSource factureDataSource
    ) {
        return
                builder.dataSource(factureDataSource)
                        .packages("com.gestion.service.api.dataaccess.entities")
                        .persistenceUnit("facture")
                        .build();
    }


    @Bean(name = "factureTransactionManager")
    @ConfigurationProperties("facture.jpa")
    public PlatformTransactionManager factureTransactionManager(
            @Qualifier("factureEntityManagerFactory") EntityManagerFactory
                    factureEntityManagerFactory
    ) {
        return new JpaTransactionManager(factureEntityManagerFactory);
    }
}
