package com.nth.SpringGradleWithHibernate.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "msSqlEntityManager",
        transactionManagerRef = "msSqlTransactionManager",
        basePackages = "com.nth.SpringGradleWithHibernate.repository.msSql"
)
public class MsSqlDBConfig {
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.msSql.datasource")
    public DataSource msSqlDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Primary
    @Bean(name = "msSqlEntityManager")
    public LocalContainerEntityManagerFactoryBean msSqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(msSqlDataSource())
                .properties(hibernateProperties())
                .packages("com.nth.SpringGradleWithHibernate.entity.msSql")
                .persistenceUnit("msSql")
                .build();
    }

    @Primary
    @Bean(name = "msSqlTransactionManager")
    public PlatformTransactionManager msSqlTransactionManager(@Qualifier("msSqlEntityManager") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Map hibernateProperties() {
        Resource resource = new ClassPathResource("hibernate.properties");

        try {
            Properties properties = PropertiesLoaderUtils.loadProperties(resource);

            return properties.entrySet().stream()
                    .collect(Collectors.toMap(
                            e -> e.getKey().toString(),
                            e -> e.getValue())
                    );
        } catch (IOException e) {
            return new HashMap();
        }
    }
}
