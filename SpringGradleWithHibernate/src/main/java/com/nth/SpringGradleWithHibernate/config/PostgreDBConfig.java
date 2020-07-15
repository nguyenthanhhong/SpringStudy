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
        entityManagerFactoryRef = "postgreEntityManager",
        transactionManagerRef = "postgreTransactionManager",
        basePackages = "com.nth.SpringGradleWithHibernate.repository.postgre"
)
public class PostgreDBConfig {
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.postgre.datasource")
    public DataSource postgreDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Primary
    @Bean(name = "postgreEntityManager")
    public LocalContainerEntityManagerFactoryBean postgreEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(postgreDataSource())
                .properties(hibernateProperties())
                .packages("com.nth.SpringGradleWithHibernate.entity.postgre")
                .persistenceUnit("postgre")
                .build();
    }

    @Primary
    @Bean(name = "postgreTransactionManager")
    public PlatformTransactionManager postgreTransactionManager(@Qualifier("postgreEntityManager") EntityManagerFactory entityManagerFactory) {
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
