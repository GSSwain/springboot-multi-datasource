package com.xxx.ddbo.suiteanalytics.configuration;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.xxx.ddbo.suiteanalytics.interfaces",
        entityManagerFactoryRef = "nsEntityManagerFactory",
        transactionManagerRef = "nsTransactionManager"
)
public class SuiteAnalyticsConfig {
    @Bean(name = "nsDataSource")
    @ConfigurationProperties(prefix="spring.suiteanalytics.datasource")
    public DataSource nsDataSource() {
        return DataSourceBuilder.create().build();
    }

    
    @Bean(name = "nsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean nsEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("nsDataSource") DataSource nsDataSource) {

        HashMap<String, Object> properties = new HashMap<>();
        //update the dialect
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        //comment the following line
        properties.put("hibernate.hbm2ddl.auto", "create");

        return builder
                .dataSource(nsDataSource)
                .properties(properties)
                .packages("com.xxx.ddbo.suiteanalytics.objects")
                .persistenceUnit("ReturnReasonsBrand")
                .build();
    }
    @Bean(name = "nsTransactionManager")
    public PlatformTransactionManager nsTransactionManager(
            @Qualifier("nsEntityManagerFactory") EntityManagerFactory nsEntityManagerFactory) {
        return new JpaTransactionManager(nsEntityManagerFactory);
    }
}

