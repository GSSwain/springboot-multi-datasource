package com.xxx.ddbo.postgresql.configuration;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.xxx.ddbo.postgresql.interfaces",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager"
)
public class PostgresqlConfig {

	@Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix="spring.postgresql.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("dataSource") DataSource dataSource) {

        HashMap<String, Object> properties = new HashMap<>();
        //update the dialect
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        //comment the following line
        properties.put("hibernate.hbm2ddl.auto", "create");

        return builder
                .dataSource(dataSource)
                .properties(properties)
                .packages("com.xxx.ddbo.postgresql.objects")
                .persistenceUnit("foo")
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}