package com.dev.alain.Config;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories (entityManagerFactoryRef = "localEntityManagerFactory", transactionManagerRef = "localTransactionManagerRef", basePackages = {
        "com.dev.alain.Repository.LocalRepository"
})
public class LocaDB {
    @Bean(name = "localDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "localEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(@Qualifier("localDataSource") DataSource dataSource){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("com.dev.alain.Entity.LocalEntity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        factoryBean.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");
        factoryBean.getJpaPropertyMap().put("hibernate.show_sql", true);
        factoryBean.getJpaPropertyMap().put("hibernate.format_sql", true);

        return factoryBean;
    }

    @Bean(name = "localTransactionManagerRef")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("localEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
