package com.nth.SpringGradleWithMyBatis.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
    @Bean(name = "dataSource", destroyMethod = "close")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource mySqlDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory mySqlSessionFactory(@Qualifier("mySqlDataSource") DataSource mySqlDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mySqlDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:sql/**/*.sql"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate mySqlSessionTemplate(SqlSessionFactory mySqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(mySqlSessionFactory);
    }

    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(mySqlDataSource());
    }

    @Bean(name = "postgreDataSource", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.postgresql.datasource")
    public DataSource postgreDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "postgreSqlSessionFactory")
    public SqlSessionFactory postgreSqlSessionFactory(@Qualifier("postgreDataSource") DataSource postgreDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(postgreDataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:sql/**/*.sql"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "postgreSqlSessionTemplate")
    public SqlSessionTemplate postgreSqlSessionTemplate(SqlSessionFactory postgreSqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(postgreSqlSessionFactory);
    }

    @Bean(name="postgreTransactionManager")
    public DataSourceTransactionManager postgreTransactionManager() {
        return new DataSourceTransactionManager(postgreDataSource());
    }
}
