package com.meicook.repository.dbconfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@org.springframework.context.annotation.Configuration
@PropertySource({"classpath:source-property.yml"})
@EnableJpaRepositories(
        basePackages = "com.meicook.repository.dbuser.*",
        entityManagerFactoryRef = "dbUserEntity",
        transactionManagerRef = "dbUserTransactionManager"
)
public class ConfigurationDbUser {

//    @Value("${${spring.profiles.active}.jpa.db-user.url}")
//    private String url;
//
//    @Value("${${spring.profiles.active}.jpa.db-user.username}")
//    private String username;
//
//    @Value("${${spring.profiles.active}.jpa.db-user.password}")
//    private String password;
//
//    @Value("${${spring.profiles.active}.jpa.db-user.platform}")
//    private String platform;
//
//    @Value("${${spring.profiles.active}.jpa.db-user.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${${spring.profiles.active}.jpa.db-user.initialization}")
//    private String initialization;
//
//    @Value("${${spring.profiles.active}.jpa.db-user.hibernate.ddl-auto}")
//    private String ddlAuto;
//
//    @Value("${${spring.profiles.active}.jpa.db-user.hibernate.dialect}")
//    private String dialect;
//
//    @Value("${${spring.profiles.active}.jpa.db-user.hibernate.naming.physical-strategy}")
//    private String physicalStrategy;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean dbUserEntity() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(userDataSource());
        em.setPackagesToScan("com.meicook.repository.dbuser.*");

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean
    public DataSource userDataSource() {
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }

    @Primary
    @Bean
    @Qualifier("dbUserTransactionManager")
    public PlatformTransactionManager dbUserTransactionManage() {
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                dbUserEntity().getObject());
        return transactionManager;
    }
}
