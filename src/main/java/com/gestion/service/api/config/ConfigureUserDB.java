package com.gestion.service.api.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
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
        transactionManagerRef = "userTransactionManager",
        entityManagerFactoryRef = "userEntityManagerFactory",
        basePackages = {"com.gestion.service.api.dataaccess.user.dao"}
)
public class ConfigureUserDB {

    @Primary
    @Bean(name="userDSProps")
    @ConfigurationProperties("user.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }




    @Primary
    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "user.datasource")
    public DataSource dataSource(@Qualifier("userDSProps") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean(name = "userEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean userEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("userDataSource") DataSource userDataSource
    ) {
        return
                builder.dataSource(userDataSource)
                        .packages("com.gestion.service.api.dataaccess.entities")
                        .persistenceUnit("user")
                        .build();
    }

    @Primary
    @Bean(name = "userTransactionManager")
    @ConfigurationProperties("user.jpa")
    public PlatformTransactionManager userTransactionManager(
            @Qualifier("userEntityManagerFactory") EntityManagerFactory
                    userEntityManagerFactory
    ) {
        return new JpaTransactionManager(userEntityManagerFactory);
    }
}
