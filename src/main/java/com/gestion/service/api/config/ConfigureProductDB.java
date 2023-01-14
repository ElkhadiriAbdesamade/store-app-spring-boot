package com.gestion.service.api.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        transactionManagerRef = "productTransactionManager",
        entityManagerFactoryRef = "productEntityManagerFactory",
        basePackages = {"com.gestion.service.api.dataaccess.product.dao"}
)
public class ConfigureProductDB {

        @Bean(name="productDSProps")
        @ConfigurationProperties("product.datasource")
        public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
        }


        @Bean(name = "productDataSource")
        @ConfigurationProperties(prefix = "product.datasource")
        public DataSource dataSource(@Qualifier("productDSProps") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
        }

        @Bean(name = "productEntityManagerFactory")
        public LocalContainerEntityManagerFactoryBean productEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("productDataSource") DataSource productDataSource
) {
        return
        builder.dataSource(productDataSource)
        .packages("com.gestion.service.api.dataaccess.entities")
        .persistenceUnit("product")
        .build();
        }


        @Bean(name = "productTransactionManager")
        @ConfigurationProperties("product.jpa")
        public PlatformTransactionManager productTransactionManager(
        @Qualifier("productEntityManagerFactory") EntityManagerFactory
                productEntityManagerFactory
) {
        return new JpaTransactionManager(productEntityManagerFactory);
        }
}
